package com.finasys.api.dtos;

import lombok.Getter;
import lombok.Setter;

public class ReportForPeriodDTO {

	@Getter @Setter
	private boolean despesa;

	@Getter @Setter
	private String valorPorCategoria;

	@Getter @Setter
	private CategoryDTO categoria;

	public ReportForPeriodDTO(boolean despesa, String valorPorCategoria, CategoryDTO categoria) {
		super();
		this.despesa = despesa;
		this.valorPorCategoria = valorPorCategoria;
		this.categoria = categoria;
	}

}
