package com.nt.service;

import java.util.List;

import com.nt.dto.BookDTO;

public interface BookStoreMgmtService {
   public List<BookDTO> fetchBooksByAuthors(String author1,String author2,String author3);
   public  String addBook(BookDTO dto);
}
