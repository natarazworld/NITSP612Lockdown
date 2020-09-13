package com.nt.entity;

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

@Entity
@Table(name="DATA_USER")
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type="int")
	private  Integer userId;
	
	@Column(length = 20)
	@Type(type="string")
	private  String name;
	
	@Column(length = 20)
	@Type(type="string")
	private  String addrs;
	
	@OneToMany(targetEntity = PhoneNumber.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_userId",referencedColumnName = "userId")
	private  Set<PhoneNumber> phones;

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

	public Set<PhoneNumber> getPhones() {
		return phones;
	}

	public void setPhones(Set<PhoneNumber> phones) {
		this.phones = phones;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", addrs=" + addrs + ", phones=" + phones + "]";
	}
	
	

}
