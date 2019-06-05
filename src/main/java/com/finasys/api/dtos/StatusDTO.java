package com.finasys.api.dtos;

import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Ricardo Lima
 * @version 31/05/2019
 *
 */

public class StatusDTO {

	@Getter	@Setter
	private Long id;

	@Size(min = 3)
	@Getter	@Setter
	private String nome;

	@Getter	@Setter
	private String descricao;
}
