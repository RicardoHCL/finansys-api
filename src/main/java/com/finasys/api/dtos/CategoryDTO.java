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

public class CategoryDTO {

	@Getter @Setter
	private Long id;

	@Getter @Setter
	@Size(min = 3, max = 30)
	private String nome;

	@Size(min = 3)
	@Getter @Setter
	private String descricao;

}
