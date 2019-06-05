package com.finasys.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.envers.Audited;

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
@Table(name = "categoria")
public class Category extends Pojo<Long>{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_categoria")
	@SequenceGenerator(name = "seq_categoria", sequenceName = "seq_categoria", allocationSize = 1)
	@Column(name = "id")
	private Long id;

	@Getter @Setter
	@Size(min = 3, max = 30)
	@Column(name = "nome", nullable = false, unique = true)
	private String nome;

	@Size(min = 3)
	@Getter @Setter
	@Column(name = "descricao", columnDefinition = "text", nullable = false)
	private String descricao;

	/*
	 * Builders ------------------------------------------------------------------
	 */

	public Category() {

	}

	public Category(Long id) {
		this.setId(id);
	}

	/*
	 * Getter's and Setter's ------------------------------------------------------------------
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
