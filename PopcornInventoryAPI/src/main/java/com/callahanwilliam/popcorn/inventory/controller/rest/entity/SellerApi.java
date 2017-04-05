package com.callahanwilliam.popcorn.inventory.controller.rest.entity;

import com.callahanwilliam.popcorn.inventory.repository.entity.ISellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * TODO Test this
 */
@RepositoryRestController
@RequestMapping("/seller")
public class SellerApi {
	
	private final ISellerRepository iSellerRepository;
	
	@Autowired
	public SellerApi(ISellerRepository iSellerRepository) {
		this.iSellerRepository = iSellerRepository;
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getSellerList() {
		return ResponseEntity.ok(iSellerRepository.findAll());
	}
}
