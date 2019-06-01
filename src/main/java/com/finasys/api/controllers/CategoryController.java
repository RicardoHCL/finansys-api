package com.finasys.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	public CategoryDTO atualizar(@Valid CategoryDTO statusDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryDTO cadastrar(@Valid CategoryDTO statusDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoryDTO consultar(Long id) {
		return this.service.consultar(id);
	}

	@Override
	public void deletar(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<CategoryDTO> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
