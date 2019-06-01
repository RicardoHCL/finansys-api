package com.finasys.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Ricardo Lima
 * @version 31/05/2019
 *
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class GenericException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public GenericException(String exception) {
		super(exception);
	}
}
