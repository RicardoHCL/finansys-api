package com.finasys.api.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finasys.api.dtos.EntryDTO;
import com.finasys.api.dtos.ReportForPeriodDTO;
import com.finasys.api.utils.FinUtil;

@Service
public class ReportsService {

	@Autowired
	private EntryService entryService;

	@Autowired
	private CategoryService categoryService;

	private List<ReportForPeriodDTO> calcularValoresPorCategorias(List<EntryDTO> listaLancamentos) {
		List<ReportForPeriodDTO> listaReportsForPeriods = new ArrayList<ReportForPeriodDTO>();
		Map<Long, BigDecimal> mapSomaValoresDespesaPorCategoria = new HashMap<Long, BigDecimal>();
		Map<Long, BigDecimal> mapSomaValoresReceitaPorCategoria = new HashMap<Long, BigDecimal>();

		listaLancamentos.forEach(lancamento -> {
			if(lancamento.isDespesa()) {
				if(!mapSomaValoresDespesaPorCategoria.containsKey(lancamento.getCategoria().getId())) {
					mapSomaValoresDespesaPorCategoria.put(lancamento.getCategoria().getId(), FinUtil.converterStringParaBigDecimal(lancamento.getValor()));
				}else {
					BigDecimal valorAtual = mapSomaValoresDespesaPorCategoria.get(lancamento.getCategoria().getId());
					valorAtual = valorAtual.add(FinUtil.converterStringParaBigDecimal(lancamento.getValor()));

					mapSomaValoresDespesaPorCategoria.replace(lancamento.getCategoria().getId(), valorAtual);
				}
			}else {
				if(!mapSomaValoresReceitaPorCategoria.containsKey(lancamento.getCategoria().getId())) {
					mapSomaValoresReceitaPorCategoria.put(lancamento.getCategoria().getId(), FinUtil.converterStringParaBigDecimal(lancamento.getValor()));
				}else {
					BigDecimal valorAtual = mapSomaValoresReceitaPorCategoria.get(lancamento.getCategoria().getId());
					valorAtual = valorAtual.add(FinUtil.converterStringParaBigDecimal(lancamento.getValor()));

					mapSomaValoresReceitaPorCategoria.replace(lancamento.getCategoria().getId(), valorAtual);
				}

			}
		});

		for(Map.Entry<Long, BigDecimal> entry : mapSomaValoresDespesaPorCategoria.entrySet()) {
			Long idCategoria = entry.getKey();
			BigDecimal valorTotal = entry.getValue();

			listaReportsForPeriods.add( new ReportForPeriodDTO(true, valorTotal.toString(), this.categoryService.consultar(idCategoria)));

		}

		for(Map.Entry<Long, BigDecimal> entry : mapSomaValoresReceitaPorCategoria.entrySet()) {
			Long idCategoria = entry.getKey();
			BigDecimal valorTotal = entry.getValue();

			listaReportsForPeriods.add( new ReportForPeriodDTO(false, valorTotal.toString(), this.categoryService.consultar(idCategoria)));

		}

		return listaReportsForPeriods;
	}

	public List<ReportForPeriodDTO> relatorioLancamentosPeriodicos(String periodoInicial, String periodoFinal) {

		return this.calcularValoresPorCategorias(
				this.entryService.consultarLancamentosPeriodicos(FinUtil.convertToDataPadrao(periodoInicial),
						FinUtil.convertToDataPadrao(periodoFinal)));
	}

}
