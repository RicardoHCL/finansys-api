package com.finasys.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finasys.api.converter.DozerConverter;
import com.finasys.api.dtos.CategoryDTO;
import com.finasys.api.exceptions.GenericException;
import com.finasys.api.models.Category;
import com.finasys.api.models.User;
import com.finasys.api.repositories.category.CategoryRepository;

/**
 *
 * @author Ricardo Lima
 * @version 31/05/2019
 *
 */

@Service
public class CategoryService extends GenericService<Category, CategoryDTO, Long, CategoryRepository> {

	@Autowired
	private CategoryRepository repository;

	@Autowired
	private EntryService entryService;

	public CategoryDTO consultar(Long id) {
		CategoryDTO categoryDTO = this.converterEntidadeParaDTO(this.consultarPorId(id).get());
		return categoryDTO;
	}

	@Override
	public Category converterDTOParaEntidade(CategoryDTO pojoDTO) {
		return DozerConverter.converterObjeto(pojoDTO, Category.class);
	}

	@Override
	public CategoryDTO converterEntidadeParaDTO(Category pojo) {
		return DozerConverter.converterObjeto(pojo, CategoryDTO.class);
	}

	@Override
	public List<CategoryDTO> converterListaEntidadeParaListaDTO(List<Category> listaPojos) {
		return DozerConverter.converterListaObjetos(listaPojos, CategoryDTO.class);
	}

	@Override
	public CategoryRepository getRepositorio() {
		return this.repository;
	}

	public List<CategoryDTO> listar() {
		return this.converterListaEntidadeParaListaDTO(this.consultarTodos());
	}

	@Override
	public void resolverPreDeletar(Category pojo, User usuario) throws GenericException {
		Long count = this.entryService.contarLancamentosVinculadoACategoria(pojo.getId());

		if (count > 0) {
			throw new GenericException("A categoria informada não pode ser excluída !");
		}
	}

	public CategoryDTO salvar(CategoryDTO categoryDTO) {
		Category category = this.converterDTOParaEntidade(categoryDTO);
		CategoryDTO categoryDTOSalvo = this.converterEntidadeParaDTO(this.salvar(category, null));
		return categoryDTOSalvo;
	}

}
