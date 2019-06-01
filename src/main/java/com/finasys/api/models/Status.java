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
@Table(name = "status")
public class Status extends Pojo<Long> {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_status")
	@SequenceGenerator(name = "seq_status", sequenceName = "seq_status", allocationSize = 1)
	private Long id;

	@Size(min = 3)
	@Getter	@Setter
	@Column(name = "nome", nullable = false,  unique = true)
	private String nome;

	@Getter	@Setter
	@Column(name = "descricao", columnDefinition = "text")
	private String descricao;

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

}
