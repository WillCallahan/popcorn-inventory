package com.callahanwilliam.popcorn.inventory.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.xml.MappingJackson2XmlView;

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
		
		//TODO Test this
		ModelAndView modelAndView = new ModelAndView();
		if (httpServletRequest.getContentType().contains(MediaType.APPLICATION_JSON.toString()))
			modelAndView.setView(new MappingJackson2JsonView());
		else if (httpServletRequest.getContentType().contains(MediaType.APPLICATION_XML.toString()))
			modelAndView.setView(new MappingJackson2XmlView());
		modelAndView.addObject("exception", exception);
		modelAndView.addObject("url", httpServletRequest.getRequestURL());
		modelAndView.setViewName(DEFAULT_ERROR_VIEW);
		return modelAndView;
	}
	
}