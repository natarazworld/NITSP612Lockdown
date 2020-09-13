package com.nt.dto;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

public class UserDTO implements Serializable {
	private  Integer userId;
	private  String name;
	private  String addrs;
	private  Set<PhoneNumberDTO> phones;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddrs() {
		return addrs;
	}

	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}

	public Set<PhoneNumberDTO> getPhones() {
		return phones;
	}

	public void setPhones(Set<PhoneNumberDTO> phones) {
		this.phones = phones;
	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", name=" + name + ", addrs=" + addrs + ", phones=" + phones + "]";
	}

	

}
