package com.callahanwilliam.popcorn.inventory.controller.form;

import com.callahanwilliam.popcorn.inventory.repository.entity.ISellerRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/index")
public class IndexController {
	
	private final Log log = LogFactory.getLog(this.getClass());
	
	private ISellerRepository iSellerRepository;
	
	@Autowired
	public IndexController(ISellerRepository iSellerRepository) {
		this.iSellerRepository = iSellerRepository;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleRequestGet(ModelAndView modelAndView) {
		log.info("Executing " + this.getClass() + "#handleRequestGet");
		log.info("Sellers " + iSellerRepository.findAll());
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
}
