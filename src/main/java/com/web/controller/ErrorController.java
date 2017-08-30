package com.web.controller;

import java.io.FileNotFoundException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice(basePackages = { "com.web.controller" })
public class ErrorController {
	public static final String DEFAULT_ERROR_VIEW = "errorPage";

	@ExceptionHandler(value = { Exception.class, NoHandlerFoundException.class, FileNotFoundException.class })
	public ModelAndView handleError(HttpServletRequest request, Exception e) throws Exception {
		ModelAndView errorPage = new ModelAndView(DEFAULT_ERROR_VIEW);
		errorPage.addObject("name", e.getClass().getSimpleName());
		errorPage.addObject("errorMsg", e.getMessage());
		errorPage.addObject("url", request.getRequestURL());
		return errorPage;
	}
}
