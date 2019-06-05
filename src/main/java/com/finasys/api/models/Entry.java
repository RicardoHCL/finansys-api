package com.finasys.api.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.envers.Audited;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.finasys.api.utils.FinUtil;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Ricardo Lima
 * @version 31/05/2019
 *
 */

@Entity
@Audited
@Table(name = "lancamento")
public class Entry extends Pojo<Long> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_lancamento")
	@SequenceGenerator(name = "seq_lancamento", sequenceName = "seq_lancamento", allocationSize = 1)
	@Column(name = "id")
	private Long id;

	@Getter
	@Setter
	@Column(name = "descricao", columnDefinition = "text")
	private String descricao;

	@Size(min = 3)
	@Getter
	@Setter
	@Column(name = "nome", nullable = false)
	private String nome;

	@NotNull
	@ManyToOne
	@Getter
	@Setter
	@JoinColumn(name = "categoria_id", nullable = false)
	private Category categoria;

	@NotNull
	@Getter
	@Setter
	@NumberFormat(style = Style.CURRENCY)
	@Column(name = "valor", nullable = false)
	private BigDecimal valor;

	@NotNull
	@Getter
	@Setter
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data", nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate data;

	@NotNull
	@ManyToOne
	@Getter
	@Setter
	@JoinColumn(name = "status_id", nullable = false)
	private Status status;

	@Getter
	@Setter
	@Column(name = "quantidade_parcelas")
	private Integer qntParcelas;

	@Getter
	@Setter
	@Column(name = "valor_parcelas")
	@NumberFormat(style = Style.CURRENCY)
	private BigDecimal vlrParcelas;

	@NotNull
	@Getter
	@Setter
	@Column(name = "parcelado", nullable = false)
	private boolean isParcelado;

	@NotNull
	@Getter
	@Setter
	@Column(name = "despesa", nullable = false)
	private boolean isDespesa;

	/*
	 * Builders ------------------------------------------------------------------
	 */

	public Entry() {

	}

	public Entry(Long id) {
		this.setId(id);
	}

	/**
	 * Full biuld for EntryConverterClass
	 *
	 * @method converterEntryDTOParaEntry
	 *
	 * @param id
	 * @param nome
	 * @param descricao
	 * @param categoriaId
	 * @param valor
	 * @param data
	 * @param isParcelado
	 * @param isDespesa
	 * @param qntParcelas
	 * @param vlrParcelas
	 * @param statusId
	 */
	public Entry(Long id, String nome, String descricao, Long categoriaId, String valor, String data,
			boolean isParcelado, boolean isDespesa, Integer qntParcelas, String vlrParcelas, Long statusId) {
		this.setId(id);
		this.setNome(nome);
		this.setDescricao(descricao);
		this.setCategoria(new Category(categoriaId));
		this.setParcelado(isParcelado);
		this.setData(FinUtil.converterStringParaLocalDate(data));
		this.setValor(FinUtil.converterStringParaBigDecimal(valor));
		this.setVlrParcelas(
				FinUtil.isNullOrEmpty(vlrParcelas) ? null : FinUtil.converterStringParaBigDecimal(vlrParcelas));
		this.setDespesa(isDespesa);
		this.setQntParcelas(qntParcelas);
		this.setStatus(new Status(statusId));
	}

	/*
	 * Getter's and Setter's
	 * ------------------------------------------------------------------
	 */

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

}
