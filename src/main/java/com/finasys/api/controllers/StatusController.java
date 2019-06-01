package com.finasys.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finasys.api.dtos.StatusDTO;
import com.finasys.api.services.StatusService;

/**
 *
 * @author Ricardo Lima
 * @version 31/05/2019
 *
 */

@CrossOrigin
@RestController
@RequestMapping("/status")
public class StatusController extends GenericController<StatusDTO, Long> {

	@Autowired
	private StatusService service;

	@Override
	public StatusDTO atualizar(@Valid @RequestBody StatusDTO statusDTO) {
		return this.service.salvar(statusDTO);
	}

	@Override
	public StatusDTO cadastrar(@Valid @RequestBody StatusDTO statusDTO) {
		return this.service.salvar(statusDTO);
	}

	@Override
	public StatusDTO consultar(@PathVariable Long id) {
		return this.service.consultar(id);
	}

	@Override
	public void deletar(@PathVariable Long id) {
		this.service.deletar(id, null);
	}

	@Override
	public List<StatusDTO> listar() {
		return this.service.listar();
	}

}
