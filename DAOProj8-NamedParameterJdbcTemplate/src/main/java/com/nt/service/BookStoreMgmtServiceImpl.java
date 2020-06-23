package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.BookBO;
import com.nt.dao.BookStoreDAO;
import com.nt.dto.BookDTO;

@Service("bookStoreService")
public class BookStoreMgmtServiceImpl implements BookStoreMgmtService {
	@Autowired
	private BookStoreDAO dao;

	@Override
	public List<BookDTO> fetchBooksByAuthors(String author1, String author2, String author3) {
		List<BookBO> listBO=null;
		List<BookDTO> listDTO=new ArrayList();
		//use service
		listBO=dao.findBooksByAuthors(author1, author2, author3);
		//convert listBO to listDTO\
		listBO.forEach(bo->{
			BookDTO dto=new BookDTO();
			BeanUtils.copyProperties(bo,dto);
			listDTO.add(dto);
		});
		return listDTO;
	}//method
	
	@Override
	public String addBook(BookDTO dto) {
		BookBO bo=null;
		int count=0;
		//convert dto to bo
		bo=new BookBO();
		BeanUtils.copyProperties(dto, bo, "bookId");
		//use dAO
		count=dao.insertBook(bo);
		return count==0?"Book insertion failed":" Book registration succeded";
	}
	
}//class
