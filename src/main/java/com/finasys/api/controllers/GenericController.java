package com.finasys.api.controllers;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


/**
 *
 * @author Ricardo Lima
 * @version 01/06/2019
 *
 */
public abstract class GenericController<ENTIDADE, ID extends Serializable> {

	@PutMapping("/{id}")
	public abstract ENTIDADE atualizar(ENTIDADE entidade);

	@PostMapping
	public abstract ENTIDADE cadastrar(ENTIDADE entidade);

	@GetMapping("/{id}")
	public abstract ENTIDADE consultar(ID id);

	@DeleteMapping("/{id}")
	public abstract void deletar(ID id);

	@GetMapping
	public abstract List<ENTIDADE> listar();

}
