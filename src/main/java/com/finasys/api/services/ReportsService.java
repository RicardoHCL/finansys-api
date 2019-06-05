package com.finasys.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finasys.api.dtos.EntryDTO;

@Service
public class ReportsService {

	@Autowired
	private EntryService entryService;


	public List<EntryDTO> relatorioLancamentosMensais(Integer month, Integer year) {
		return this.entryService.consultarEntriesPorMesEAano(month, year);
	}
}
