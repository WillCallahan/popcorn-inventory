package com.callahanwilliam.popcorn.inventory.domain.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Seller DMO for SELLER
 */
@Entity
@Table(name = "SELLER")
@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Seller implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "SELLER_ID")
	private long sellerId;
	
	@Column(name = "SELLER_FNAME")
	private String firstName;
	
	@Column(name = "SELLER_MNAME")
	private String middleName;
	
	@Column(name = "SELLER_LNAME")
	private String lastName;
	
	@Column(name = "SELLER_PHONE")
	private String phone;
	
	@Column(name = "SELLER_ADDRESS_ID", insertable = false, updatable = false)
	private Integer addressId;

	public Seller() {

	}

	public long getSellerId() {
		return sellerId;
	}

	public void setSellerId(long sellerId) {
		this.sellerId = sellerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	
}
