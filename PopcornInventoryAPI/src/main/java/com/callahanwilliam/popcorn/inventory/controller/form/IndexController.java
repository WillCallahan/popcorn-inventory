package com.callahanwilliam.popcorn.inventory.controller.form;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/index")
public class IndexController {
	
	private final Log log = LogFactory.getLog(this.getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleRequestGet(ModelAndView modelAndView) {
		log.info("Executing " + this.getClass() + "#handleRequestGet");
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
}
