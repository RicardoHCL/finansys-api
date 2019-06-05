package com.finasys.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finasys.api.converter.DozerConverter;
import com.finasys.api.dtos.StatusDTO;
import com.finasys.api.exceptions.GenericException;
import com.finasys.api.models.Status;
import com.finasys.api.models.User;
import com.finasys.api.repositories.status.StatusRepository;

/**
 *
 * @author Ricardo Lima
 * @version 31/05/2019
 *
 */

@Service
public class StatusService extends GenericService<Status, StatusDTO, Long, StatusRepository> {

	@Autowired
	private StatusRepository repository;

	@Autowired
	private EntryService entryService;

	public StatusDTO consultar(Long id) {
		StatusDTO statusDTO = this.converterEntidadeParaDTO(this.consultarPorId(id).get());
		return statusDTO;
	}

	@Override
	public Status converterDTOParaEntidade(StatusDTO pojoDTO) throws GenericException {
		return DozerConverter.converterObjeto(pojoDTO, Status.class);
	}

	@Override
	public StatusDTO converterEntidadeParaDTO(Status pojo) throws GenericException {
		return DozerConverter.converterObjeto(pojo, StatusDTO.class);
	}

	@Override
	public List<StatusDTO> converterListaEntidadeParaListaDTO(List<Status> listaPojos) {
		return DozerConverter.converterListaObjetos(listaPojos, StatusDTO.class);
	}

	@Override
	public StatusRepository getRepositorio() {
		return this.repository;
	}

	public List<StatusDTO> listar() {
		return this.converterListaEntidadeParaListaDTO(this.consultarTodos());
	}

	@Override
	public void resolverPreDeletar(Status pojo, User usuario) throws GenericException {
		Long count = this.entryService.contarLancamentosVinculadoAoStatus(pojo.getId());

		if (count > 0) {
			throw new GenericException("O status informado não pode ser excluído !");
		}
	}

	public StatusDTO salvar(StatusDTO statusDTO) {
		Status status = this.converterDTOParaEntidade(statusDTO);
		StatusDTO statusDTOSalvo = this.converterEntidadeParaDTO(this.salvar(status, null));
		return statusDTOSalvo;
	}

}
