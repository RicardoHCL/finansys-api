package com.finasys.api.services;

import java.io.Serializable;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.transaction.annotation.Transactional;

import com.finasys.api.exceptions.GenericException;
import com.finasys.api.models.Pojo;
import com.finasys.api.models.User;
import com.finasys.api.repositories.GenericRepository;
import com.finasys.api.utils.FinUtil;

/**
 *
 * @author Ricardo Lima
 * @version 31/05/2019
 */
public abstract class GenericService<ENTIDADE extends Pojo<ID>, ID extends Serializable, REPOSITORIO extends GenericRepository<ENTIDADE, ID>> {

	@Autowired
	private MessageSource messageSource;

	@Transactional(readOnly = true)
	public ENTIDADE buscar(ID id) {
		return this.getRepositorio().buscar(id);
	}

	@Transactional(readOnly = true)
	public void excluir(ENTIDADE pojo, User usuario) throws GenericException {
		this.validarExclusao(pojo);
		this.resolverPreExcluir(pojo, usuario);
		this.excluirEntidade(pojo.getId());
	}

	@Transactional(readOnly = true)
	public void excluirSemDependenciasSemValidacao(ID id) {
		this.excluirEntidade(id);
	}

	@Transactional(rollbackFor=Exception.class)
	public void inativar(ENTIDADE pojo, User usuario) throws GenericException {
		this.validarInativacao(pojo);
		this.resolverPreInativar(pojo, usuario);
		ENTIDADE entidade = this.buscar(pojo.getId());
		entidade.setAtivo(false);
		entidade.setDataExclusao(FinUtil.getDataAtual());
		if(usuario != null) {
			entidade.setUsuario(new User(usuario.getId()));
		}
		this.salvarSemDependenciasSemValidacao(entidade, usuario);
		this.resolverPosInativar(pojo, usuario);
	}

	@Transactional(rollbackFor = Exception.class)
	public void salvarSemDependenciasSemValidacao(ENTIDADE pojo, User usuario) throws GenericException {
		if(pojo.getUsuario() != null && pojo.getUsuario().getId() == null){
			pojo.setUsuario(null);
		}
		ENTIDADE pojoBanco = this.salvarEntidade(pojo, usuario);
		pojo.setId(pojoBanco.getId());
	}

	@Transactional(rollbackFor = Exception.class)
	public ENTIDADE salvar(ENTIDADE pojo, User usuario) throws GenericException {
		if(pojo.getId() == null) {
			this.validarInclusao(pojo);
		}else{
			this.validarAlteracao(pojo);
		}
		this.validarUnicidade(pojo);
		this.resolverPreDependencias(pojo, usuario);
		if(pojo.getUsuario() != null && pojo.getUsuario().getId()== null){
			pojo.setUsuario(null);
		}
		ENTIDADE pojoBanco = this.salvarEntidade(pojo, usuario);
		pojo.setId(pojoBanco.getId());
		this.resolverPosDependencias(pojo, usuario);
		
		return pojo;
	}

	protected ENTIDADE salvarEntidade(ENTIDADE pojo, User usuario) throws GenericException {
		pojo.setDataAlteracao(FinUtil.getDataAtual());
		User usuarioAux = null;
		if (usuario != null) {
			usuarioAux = new User();
			usuarioAux.setId(usuario.getId());
			pojo.setUsuario(usuarioAux);
		}
		if (pojo.getId() == null) {
			pojo.setUsuario(usuarioAux);
			pojo.setDataInclusao(FinUtil.getDataAtual());
			pojo.setAtivo(true);
		}
		if (pojo.getUsuario() != null && pojo.getUsuario().getId() == null) {
			pojo.setUsuario(usuarioAux);
		}
		usuarioAux = null;
		ENTIDADE pojoBanco = null;
		try {
			pojoBanco = this.persistirEntidade(pojo);
		} catch (ObjectOptimisticLockingFailureException e) {
			e.printStackTrace();
			throw new GenericException(this.getMensagem("Entidade Já Foi Alterada!"));
		}
		return pojoBanco;
	}

	public String getMensagem(String key) {
		return this.messageSource.getMessage(key, null, new Locale("pt", "BR"));
	}

	public String getMensagem(String key, String... parametros) {
		return this.messageSource.getMessage(key, parametros, new Locale("pt", "BR"));
	}

	public abstract REPOSITORIO getRepositorio();

	abstract ENTIDADE persistirEntidade(ENTIDADE pojo);

	abstract void excluirEntidade(ID id);

	public void resolverPosDependencias(ENTIDADE pojo, User usuario) throws GenericException { }

	public void resolverPosInativar(ENTIDADE pojo, User usuario) throws GenericException { }

	public void resolverPreDependencias(ENTIDADE pojo, User usuario) throws GenericException { }

	public void resolverPreExcluir(ENTIDADE pojo, User usuario) throws GenericException { }

	public void resolverPreInativar(ENTIDADE pojo, User usuario) throws GenericException { }

	public void validarAlteracao(ENTIDADE pojo) throws GenericException { }

	public void validarExclusao(ENTIDADE pojo) throws GenericException { }

	public void validarInativacao(ENTIDADE pojo) throws GenericException { }

	public void validarInclusao(ENTIDADE pojo) throws GenericException { }

	public void validarUnicidade(ENTIDADE pojo) throws GenericException { }

}
