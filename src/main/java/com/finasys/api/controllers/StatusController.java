package com.finasys.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
public class StatusController {

	@Autowired
	private StatusService service;

	@GetMapping("/{id}")
	public StatusDTO consultar(@PathVariable Long id) {
		return this.service.consultar(id);
	}

	@GetMapping
	public List<StatusDTO> listar(){
		return this.service.listar();
	}

	@PostMapping
	public StatusDTO salvar(@Valid @RequestBody StatusDTO statusDTO) {
		return this.service.salvar(statusDTO);
	}

}
