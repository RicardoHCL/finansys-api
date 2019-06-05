package com.finasys.api.dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	@Getter	@Setter
	private boolean despesa;

	@Getter	@Setter
	@Size(min = 3, max = 30)
	private String nome;

	@Size(min = 3)
	@Getter	@Setter
	private String descricao;

	@NotNull
	@Getter	@Setter
	private String valor;

	@NotNull
	@Getter	@Setter
	private String data;

	@NotNull
	@Getter	@Setter
	private Long categoriaId;

	@NotNull
	@Getter	@Setter
	private Long statusId;

	@Getter	@Setter
	private Long id;

	@Getter @Setter
	private boolean parcelado;

	@Getter	@Setter
	private Integer qntParcelas;

	@Getter	@Setter
	private String vlrParcelas;

	@Getter	@Setter
	private CategoryDTO categoria;

	@Getter	@Setter
	private StatusDTO status;

	/*
	 * Builders ------------------------------------------------------------------
	 */


	public EntryDTO() {

	}

	/**
	 *
	 * Full build for EntryConverterClass
	 *
	 * @method converterEntryParaEntryDTO
	 *
	 * @param id
	 * @param nome
	 * @param descricao
	 * @param valor
	 * @param data
	 * @param parcelado
	 * @param despesa
	 * @param qntParcelas
	 * @param vlrParcelas
	 * @param categoria
	 * @param status
	 */
	public EntryDTO(Long id, String nome, String descricao, String valor, String data, boolean parcelado,
			boolean despesa, Integer qntParcelas, String vlrParcelas, CategoryDTO categoria, StatusDTO status) {

		this.setId(id);
		this.setNome(nome);
		this.setDescricao(descricao);
		this.setValor(valor);
		this.setData(data);
		this.setParcelado(parcelado);
		this.setDespesa(despesa);
		this.setQntParcelas(qntParcelas);
		this.setVlrParcelas(vlrParcelas);
		this.setCategoria(categoria);
		this.setCategoriaId(categoria.getId());
		this.setStatus(status);
		this.setStatusId(status.getId());
	}

}
