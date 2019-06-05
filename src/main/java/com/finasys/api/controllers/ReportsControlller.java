package com.finasys.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finasys.api.dtos.EntryDTO;
import com.finasys.api.services.ReportsService;

/**
 *
 * @author Ricardo Lima
 * @version 02/06/2019
 *
 */

@CrossOrigin
@RestController
@RequestMapping("/relatorios")
public class ReportsControlller  {


	@Autowired
	private ReportsService service;

	@GetMapping("/{month}/{year}")
	public List<EntryDTO> relatorioLancamentosMensais(@PathVariable(name = "month") Integer month, @PathVariable(name = "year") Integer year) {
		return this.service.relatorioLancamentosMensais(month, year);
	}

}
