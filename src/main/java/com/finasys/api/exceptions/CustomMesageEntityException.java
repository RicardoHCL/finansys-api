package com.finasys.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.finasys.api.utils.FinUtil;

/**
 *
 * @author Ricardo Lima
 * @version 31/05/2019
 *
 */

@RestController
@ControllerAdvice
public class CustomMesageEntityException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> renderizarExceptions(Exception ex, WebRequest request ) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(FinUtil.getDataAtual(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(GenericException.class)
	public final ResponseEntity<ExceptionResponse> renderizarGenericException(Exception ex, WebRequest request ) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(FinUtil.getDataAtual(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

}
