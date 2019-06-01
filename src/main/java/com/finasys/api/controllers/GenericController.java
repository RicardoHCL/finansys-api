package com.finasys.api.controllers;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 *
 * @author Ricardo Lima
 * @version 01/06/2019
 *
 */
public abstract class GenericController<ENTIDADE, ID extends Serializable> {

	@PutMapping
	abstract ENTIDADE atualizar(@Valid @RequestBody ENTIDADE statusDTO);

	@PostMapping
	abstract ENTIDADE cadastrar(@Valid @RequestBody ENTIDADE statusDTO);

	@GetMapping("/{id}")
	abstract ENTIDADE consultar(@PathVariable ID id);

	@DeleteMapping("/{id}")
	abstract void excluir(@PathVariable ID id);

	@GetMapping
	abstract List<ENTIDADE> listar();

}
