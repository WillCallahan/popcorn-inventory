package com.callahanwilliam.popcorn.inventory.controller.rest.entity;

import com.callahanwilliam.popcorn.inventory.domain.entity.Seller;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * TODO Test this
 */
@RepositoryRestResource(collectionResourceRel = "seller", path = "seller")
public interface ISellerApi extends PagingAndSortingRepository<Seller, Long> {
	
	List<Seller> findAll();
	
}
