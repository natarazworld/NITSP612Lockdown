package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

@Entity
public class Project implements Serializable {
	@Id
	@Type(type="int")
	@GeneratedValue(strategy = GenerationType.AUTO )   //JPA  Generator  (either identity/sequence)
	private Integer projId;
	
	@Column(length = 20,unique = true,nullable = false)
	@Type(type="string")
	private String projName;
	
	@Type(type="int")
	private Integer teamSize;
	
	@Column(length = 20,nullable = false)
	@Type(type="string")
	private  String company;
	
	@Column(length = 20)
	@Type(type="string")
	private  String location;
	
	@Type(type="double")
	private  Double cost;

	public Integer getProjId() {
		return projId;
	}

	public void setProjId(Integer projId) {
		this.projId = projId;
	}

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public Integer getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(Integer teamSize) {
		this.teamSize = teamSize;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

/*	@Override
	public String toString() {
		return "Project [projId=" + projId + ", projName=" + projName + ", teamSize=" + teamSize + ", company="
				+ company + ", location=" + location + ", cost=" + cost + "]";
	}*/
	
	

}
