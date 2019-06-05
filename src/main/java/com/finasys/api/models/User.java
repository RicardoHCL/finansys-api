package com.finasys.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

/**
 *
 * @author Ricardo Lima
 * @version 31/05/2019
 *
 */

@Entity
@Audited
@Table(name = "usuario")
public class User extends Pojo<Long> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
	@SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario", allocationSize = 1)
	@Column(name = "id")
	private Long id;

	/*
	 * Builders ------------------------------------------------------------------
	 */

	public User() {

	}

	public User(Long id) {
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
