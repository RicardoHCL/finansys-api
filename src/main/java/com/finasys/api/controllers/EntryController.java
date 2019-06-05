package com.finasys.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finasys.api.dtos.EntryDTO;
import com.finasys.api.services.EntryService;

/**
 *
 * @author Ricardo Lima
 * @version 01/06/2019
 *
 */

@CrossOrigin
@RestController
@RequestMapping("/lancamentos")
public class EntryController extends GenericController<EntryDTO, Long> {

	@Autowired
	private EntryService service;

	@Override
	public EntryDTO atualizar(@Valid @RequestBody EntryDTO entidade) {
		return this.service.salvar(entidade);
	}

	@Override
	public EntryDTO cadastrar(@Valid @RequestBody EntryDTO entidade) {
		return this.service.salvar(entidade);
	}

	@Override
	public EntryDTO consultar(@PathVariable Long id) {
		return this.service.consultar(id);
	}

	@Override
	public void deletar(@PathVariable Long id) {
		this.service.inativar(id, null);
	}

	@Override
	public List<EntryDTO> listar() {
		return this.service.listar();
	}

}
