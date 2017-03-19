package com.callahanwilliam.popcorn.inventory.repository.entity;

import com.callahanwilliam.popcorn.inventory.domain.entity.Seller;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Repository for the {@link Seller} {@link javax.persistence.Entity}
 */
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
public interface ISellerRepository extends CrudRepository<Seller, Long> {
	
	/**
	 * {@inheritDoc}
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	<S extends Seller> S save(S entity);
	
	/**
	 * {@inheritDoc}
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	<S extends Seller> Iterable<S> save(Iterable<S> entities);
	
	/**
	 * {@inheritDoc}
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	void delete(Long aLong);
	
	/**
	 * {@inheritDoc}
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	void delete(Seller entity);
	
	/**
	 * {@inheritDoc}
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	void delete(Iterable<? extends Seller> entities);
	
	/**
	 * {@inheritDoc}
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	void deleteAll();
}
