package com.project.PokeDex.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.project.PokeDex.controller.PokemonController;
import com.project.PokeDex.exceptions.PokeExceptions;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
	
	private static final Logger LOGGER = LogManager.getLogger(ExceptionHandler.class);
	
	@org.springframework.web.bind.annotation.ExceptionHandler(value = {PokeExceptions.class})
	protected ResponseEntity<Object> handlerConflict(PokeExceptions ex, WebRequest request){
		String bodyOfResponse = ex.getMessage();
		LOGGER.error("Error in request "+bodyOfResponse);
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), ex.getHttpStatus(), request);
	}


}
