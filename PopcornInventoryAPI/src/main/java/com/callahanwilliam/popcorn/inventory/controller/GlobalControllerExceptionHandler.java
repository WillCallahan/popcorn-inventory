package com.callahanwilliam.popcorn.inventory.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Handles all uncaught exceptions
 */
@ControllerAdvice
class GlobalControllerExceptionHandler {
	private static final String DEFAULT_ERROR_VIEW = "index";
	
	private final Log log = LogFactory.getLog(this.getClass());
	
	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest httpServletRequest, Exception exception) throws Exception {
		// If the exception is annotated with @ResponseStatus rethrow it and let
		// the framework handle it - like the OrderNotFoundException example
		// at the start of this post.
		// AnnotationUtils is a Spring Framework utility class.
		if (AnnotationUtils.findAnnotation(exception.getClass(), ResponseStatus.class) != null)
			throw exception;
		
		log.error("Unhandled exception!", exception);
		
		//TODO handle content negotiation
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("exception", exception);
		modelAndView.addObject("url", httpServletRequest.getRequestURL());
		modelAndView.setViewName(DEFAULT_ERROR_VIEW);
		return modelAndView;
	}
	
}