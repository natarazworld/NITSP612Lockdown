package com.nt.model;

import org.springframework.web.multipart.MultipartFile;

public class JobSeekerInfo {
  private String jsName;
  private String jsAddrs;
  private MultipartFile resume;
  private MultipartFile photo;
public String getJsName() {
	return jsName;
}
public void setJsName(String jsName) {
	this.jsName = jsName;
}
public String getJsAddrs() {
	return jsAddrs;
}
public void setJsAddrs(String jsAddrs) {
	this.jsAddrs = jsAddrs;
}
public MultipartFile getResume() {
	return resume;
}
public void setResume(MultipartFile resume) {
	this.resume = resume;
}
public MultipartFile getPhoto() {
	return photo;
}
public void setPhoto(MultipartFile photo) {
	this.photo = photo;
}
  
}
