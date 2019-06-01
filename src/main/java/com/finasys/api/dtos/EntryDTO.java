package com.finasys.api.dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.finasys.api.models.Category;
import com.finasys.api.models.Status;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Ricardo Lima
 * @version 31/05/2019
 *
 */

public class EntryDTO {

	@NotNull
	@Getter @Setter
	private boolean despesa;

	@Getter @Setter
	@Size(min = 3, max = 30)
	private String nome;

	@Size(min = 3)
	@Getter @Setter
	private String descricao;

	@NotNull
	@Getter @Setter
	private String valor;

	@NotNull
	@Getter @Setter
	private String data;

	@NotNull
	@Getter @Setter
	private Long categoriaId;

	@NotNull
	@Getter @Setter
	private Long statusId;

	@Getter @Setter
	private Long id;

	@Getter @Setter
	private boolean parcelado;

	@Getter @Setter
	private Integer qntParcelas;

	@Getter @Setter
	private String vlrParcelas;

	@Getter @Setter
	private Category categoria;

	@Getter @Setter
	private Status status;

}
