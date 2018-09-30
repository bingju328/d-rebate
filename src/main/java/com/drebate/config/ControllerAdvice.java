package com.drebate.config;

import com.drebate.exception.BizException;
import com.drebate.exception.UnauthenticatedException;
import com.drebate.exception.UnauthorizedException;
import com.drebate.model.datamodel.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ValidationException;

@RestControllerAdvice
public class ControllerAdvice {

	private Logger logger = LoggerFactory.getLogger(ControllerAdvice.class);

	@ModelAttribute
	void pre(HttpServletRequest request) {
		logger.debug("REQUEST URI = " + request.getRequestURI());
	}

	@ExceptionHandler(ValidationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Result handleValidationException(ValidationException e, HttpServletRequest request, HttpServletResponse response)  {
		logger.error(String.format("remote host %s ,uri %s , referer %s", request.getRemoteHost(), request.getRequestURI(), request.getHeader(HttpHeaders.REFERER)));
		logger.error(e.getMessage(), e);
		response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		return Result.builder().code(HttpStatus.BAD_REQUEST.value()).message(e.getMessage()).build();

	}

	@ExceptionHandler(BizException.class)
	@ResponseStatus(HttpStatus.OK)
	public Result handleBizException(BizException e, HttpServletResponse response)  {
		logger.error(e.getMessage(), e);
		response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		return Result.builder().code(e.getCode()).message(e.getMessage()).build();
	}

	@ExceptionHandler(UnauthenticatedException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public Result handleUnauthenticatedException(UnauthenticatedException e, HttpServletResponse response)  {
		logger.error(e.getMessage(), e);
		response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		return Result.builder().code(HttpStatus.UNAUTHORIZED.value()).message(e.getMessage()).build();
	}

	@ExceptionHandler(UnauthorizedException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public Result handleUnauthorizedException(UnauthorizedException e, HttpServletResponse response)  {
		logger.error(e.getMessage(), e);
		response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		return Result.builder().code(HttpStatus.FORBIDDEN.value()).message(e.getMessage()).build();
	}

	@ExceptionHandler(Throwable.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Result handleException(Throwable e, HttpServletResponse response)  {
		logger.error(e.getMessage(), e);
		response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		return Result.builder().code(HttpStatus.INTERNAL_SERVER_ERROR.value()).message(e.getMessage()).build();
	}

}
