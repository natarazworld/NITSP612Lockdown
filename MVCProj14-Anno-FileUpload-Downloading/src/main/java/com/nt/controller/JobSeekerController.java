package com.nt.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.model.JobSeekerInfo;
import com.nt.service.FileMgmtService;

@Controller
public class JobSeekerController {
	@Autowired
	private ServletContext sc;
	@Autowired
	private FileMgmtService service;
	
	@GetMapping("/upload")
	public   String showUploadForm(@ModelAttribute("jsFrm") JobSeekerInfo info) {
		return "jobseeker_form";
	}
	
	@PostMapping("/upload")
	public   String  uploadFiles(Map<String,Object>map,
			                                    @ModelAttribute("jsFrm")JobSeekerInfo info) throws Exception {
		
		//get  upload folder location from web.xml file context param
		String folderLocation=sc.getInitParameter("uploadStore");  //get e:/store folder as string
		//check wheather that folder is avialble or not , if not create a new folder
		File file=new File(folderLocation);   // makes e:/store as File object
		if(!file.exists())  //checks  store folder availability in e: dirive
			 file.mkdir();  //if not there creates new strore folder
		//get upploaded file names
		 String resumeFileName=info.getResume().getOriginalFilename();
		 String photoFileName=info.getPhoto().getOriginalFilename();
		 //create InputStreams pointing uploaded files content
		 InputStream resumeIs=info.getResume().getInputStream();
		 InputStream photoIs=info.getPhoto().getInputStream();
		 //create OutputStreams pointing empty destination files
		 OutputStream resumeOs=new FileOutputStream(folderLocation+"/"+resumeFileName);
		 OutputStream photoOs=new FileOutputStream(folderLocation+"/"+photoFileName);
		 //copy uploaded files content to destination files  (complets the file uploading process)
		 IOUtils.copy(resumeIs, resumeOs);
		 IOUtils.copy(photoIs,photoOs);
		 //keep the name of the uploaded files as model attributes
		 map.put("resumeFileName", resumeFileName);
		 map.put("photoFileName", photoFileName);
		 //close streams
		 resumeOs.close();
		 resumeIs.close();
		 photoOs.close();
		 photoIs.close();
		 //return lvn
		return "upload_success";
	}//method
	
	@GetMapping("/list_files")
	public   String   showAllFiles(Map<String,Object> map) {
		//get  uploadStore folder name form web.xml file as context param value
		String  uploadStore=sc.getInitParameter("uploadStore");
       //use service
		 List<String> fileNamesList=service.fetchAllFiles(uploadStore);
		 //keep results in model attribute
		 map.put("filesList",fileNamesList);
		 //return lvn
		return "show_files";
	}
	
	@GetMapping("/download")
	public   String   downloadFile(@RequestParam("fname") String fileName,
			                                            HttpServletResponse res)throws Exception {
		//get path of donwloadable file
		String filePath=sc.getInitParameter("uploadStore")+"/"+fileName;   // gives E:/store/abc.txt
		//create File object pointing to the file to be dowloaded
		File file=new File(filePath);  
		//set file length as response content length
		res.setContentLengthLong(file.length());
		//get MIME type of the file and make it as response content type
		String mimeType=sc.getMimeType(filePath);
		res.setContentType(mimeType==null?"application/octet-stream":mimeType);
		//create InputStream pointing to the flle to be downloaded
		InputStream is=new FileInputStream(filePath);
		//create OutputStream pointing  response obj
		OutputStream os=res.getOutputStream();
		//Give instruction to browser to make the recived content as downloadable 
		res.addHeader("Content-Disposition","attachment;fileName="+fileName);   //makes browser to display download dialog box
		//copy file content to response obj
		IOUtils.copy(is, os);
         //take lvn as null		
		return null;
	}
	
}//class
