package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="DATA_PHONENUMBER")
public class PhoneNumber implements  Serializable {
	@Id
	@Type(type="long")
	private Long mobileNo;
	
	@Column(length=10)
	@Type(type="string")
	private String  type;
	
	@Column(length=15)
	@Type(type="string")
	private String provider;

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	@Override
	public String toString() {
		return "PhoneNumber [mobileNo=" + mobileNo + ", type=" + type + ", provider=" + provider + "]";
	}
	
	
	
	

}
