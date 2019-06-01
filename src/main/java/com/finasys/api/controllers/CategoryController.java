package com.finasys.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finasys.api.dtos.CategoryDTO;
import com.finasys.api.services.CategoryService;

/**
 *
 * @author Ricardo Lima
 * @version 01/06/2019
 *
 */

@CrossOrigin
@RestController
@RequestMapping("/categorias")
public class CategoryController extends GenericController<CategoryDTO, Long> {

	@Autowired
	private CategoryService service;

	@Override
	public CategoryDTO atualizar(@Valid @RequestBody CategoryDTO categoryDTO) {
		return this.service.salvar(categoryDTO);
	}

	@Override
	public CategoryDTO cadastrar(@Valid @RequestBody CategoryDTO categoryDTO) {
		return this.service.salvar(categoryDTO);
	}

	@Override
	public CategoryDTO consultar(@PathVariable Long id) {
		return this.service.consultar(id);
	}

	@Override
	public void deletar(@PathVariable Long id) {
		this.service.deletar(id, null);
	}

	@Override
	public List<CategoryDTO> listar() {
		return this.service.listar();
	}

}
