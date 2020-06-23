package com.nt.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.BookBO;

@Repository("bookStoreDAO")
public class BookStoreDAOImpl implements BookStoreDAO {
	private static final String  GET_BOOKS_BY_AUTHORS="SELECT BOOKID,BOOKNAME,AUTHOR,PRICE,PUBLISHER,STATUS,CATEGORY FROM BOOK_STORE WHERE AUTHOR IN(:auth1,:auth2,:auth3) ORDER BY AUTHOR";
	private static final String  INSERT_BOOK_STORE_QUERY="INSERT INTO BOOK_STORE VALUES(BKID_SEQ.NEXTVAL,:bookName,:author,:price,:publisher,:status,:category)";
	
	@Autowired
	private NamedParameterJdbcTemplate npjt;

	@Override
	public List<BookBO> findBooksByAuthors(String author1, String author2, String author3) {
		List<BookBO> listBO1=null;
		Map<String,Object> paramsMap=null;
		//set values to named params
		paramsMap=new HashMap();
		paramsMap.put("auth1",author1);
		paramsMap.put("auth2",author2);
		paramsMap.put("auth3",author3);
		listBO1=npjt.query(GET_BOOKS_BY_AUTHORS,
				          paramsMap,
				          rs->{
				        	List<BookBO> listBO=null;
				        	BookBO bo=null;
				        	listBO=new ArrayList();
				        	while(rs.next()) {
				        		bo=new BookBO();
				        		bo.setBookId(rs.getInt(1));
				        		bo.setBookName(rs.getString(2));
				        		bo.setAuthor(rs.getString(3));
				        		bo.setPrice(rs.getFloat(4));
				        		bo.setPublisher(rs.getString(5));
				        		bo.setStatus(rs.getString(6));
				        		bo.setCategory(rs.getString(7));
				        		listBO.add(bo);
				        	}
				        	 return listBO; 
				          });
		return listBO1;
				
	}//method
	
	/*@Override
	public int insertBook(BookBO bo) {
		MapSqlParameterSource msps=null;
		int count=0;
		//prpeare param values
		msps=new MapSqlParameterSource();
		msps.addValue("bookName", bo.getBookName());
		msps.addValue("author",bo.getAuthor());
		msps.addValue("price", bo.getPrice());
		msps.addValue("publisher",bo.getPublisher());
		msps.addValue("status", bo.getStatus());
		msps.addValue("category",bo.getCategory());
		count=npjt.update(INSERT_BOOK_STORE_QUERY, msps);
		return count;
	}*/
	
	
	@Override
	public int insertBook(BookBO bo) {
		BeanPropertySqlParameterSource bpsps=null;
		int count=0;
		//prpeare param values
		bpsps=new BeanPropertySqlParameterSource(bo);
		count=npjt.update(INSERT_BOOK_STORE_QUERY, bpsps);
		return count;
	}
	
	
}//class
