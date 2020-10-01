package com.nt.dto;

import java.io.Serializable;

public class StudentDTO implements Serializable {
    private int sno;
    private String sname;
    private String sadd;
    
    
    
    
    public StudentDTO(int sno, String sname, String sadd) {
		this.sno = sno;
		this.sname = sname;
		this.sadd = sadd;
	}



	public int getSno() {
		return sno;
	}



	public void setSno(int sno) {
		this.sno = sno;
	}



	public String getSname() {
		return sname;
	}



	public void setSname(String sname) {
		this.sname = sname;
	}



	public String getSadd() {
		return sadd;
	}



	public void setSadd(String sadd) {
		this.sadd = sadd;
	}



	@Override
	public String toString() {
		return "StudentDTO [sno=" + sno + ", sname=" + sname + ", sadd=" + sadd + "]";
	}
	
    
}
