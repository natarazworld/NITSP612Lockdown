package com.nt.dao;

import java.util.List;

import com.nt.bo.BookBO;

public interface BookStoreDAO {
	public List<BookBO>  findBooksByAuthors(String author1,String author2,String author3);
    public  int insertBook(BookBO bo);
    
}
