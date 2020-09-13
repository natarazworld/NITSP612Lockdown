package com.nt.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

public class PhoneNumberDTO implements  Serializable {
	private Long mobileNo;
	private String  type;
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
		return "PhoneNumberDTO [mobileNo=" + mobileNo + ", type=" + type + ", provider=" + provider + "]";
	}

	
	
	
	

}
