package com.finasys.api.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.hibernate.envers.Audited;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Ricardo Lima
 * @version 31/05/2019
 *
 */

@Audited
@MappedSuperclass
public abstract class Pojo<ID extends Serializable> implements IEntidade<ID> {

	private static final long serialVersionUID = 1L;

	@Getter @Setter
	@Column(name = "ativo", nullable = false)
	private boolean ativo;

	@Getter @Setter
	@Column(name = "data_alteracao", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss.SSS")
	private LocalDateTime dataAlteracao;

	@Getter @Setter
	@Column(name = "data_exclusao")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss.SSS")
	private LocalDateTime dataExclusao;

	@Getter @Setter
	@Column(name = "data_inclusao", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss.SSS")
	private LocalDateTime dataInclusao;

	@Getter @Setter
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	private User usuario;

	/*
	 * HashCode and Equals ------------------------------------------------------------------
	 */

	@Override
	@SuppressWarnings("rawtypes")
	public boolean equals(Object obj) {
		boolean equals = false;
		try {
			if (obj != null) {
				if ((this.getId() != null) && (this.getId().equals(((Pojo) obj).getId()))) {
					equals = true;
				} else if (obj == this) {
					equals = true;
				}
			}
		} catch (ClassCastException e) {
			equals = false;
		}
		return equals;
	}

	@Override
	public int hashCode() {
		return this.getId() != null ? this.getId().hashCode() : super.hashCode();
	}

}
