package com.nt.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service("fileService")
public class FileMgmtServiceImpl implements FileMgmtService {

	@Override
	public List<String> fetchAllFiles(String uploadStore) {
		//create File object reprsenting  uplodStore folder (E:/store)
		File fileStore=new File(uploadStore);
		//get All files and subfolders of   uploadStore folder (E:/store)
		File content[]=fileStore.listFiles();
		List<String> fileNamesList=new ArrayList();
		for(File f:content) {
			   if(f.isFile())
				   fileNamesList.add(f.getName());
		}//for
		return fileNamesList;
	}//method

}//class
