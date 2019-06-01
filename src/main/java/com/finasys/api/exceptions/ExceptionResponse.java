package com.finasys.api.exceptions;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Getter;

/**
 *
 * @author Ricardo Lima
 * @version 31/05/2019
 *
 */

public class ExceptionResponse implements Serializable{

	private static final long serialVersionUID = 1L;

	@Getter
	private LocalDateTime data;

	@Getter
	private String mensagem;

	@Getter
	private String descricao;

	public ExceptionResponse(LocalDateTime data, String mensagem, String descricao) {
		super();
		this.data = data;
		this.mensagem = mensagem;
		this.descricao = descricao;
	}



}
