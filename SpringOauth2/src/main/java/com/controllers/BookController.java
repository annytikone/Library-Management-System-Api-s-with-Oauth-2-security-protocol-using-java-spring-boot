package com.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.books.book;
import com.books.daoBooks;

@RestController
public class BookController {
	@Autowired
	daoBooks dao;

    @CrossOrigin(origins = "http://localhost:61458")
	@RequestMapping("/api/book/{id}")
	public List<book> singleInfo(@PathVariable("id") Long id) {
		List<book> books = dao.singleData(id);
		return books;
	}
	
    @CrossOrigin(origins = "http://localhost:61458")
	@RequestMapping("api/getinfoByBookName/{bookname}")
	public List<book> bookInformationByname( @PathVariable("bookname") String bookname) {
		List<book> books = dao.getBookByName(bookname);
		return books;
	}
	
    @CrossOrigin(origins = "http://localhost:61458")
	@RequestMapping("api/getAllBookInfo")
	public List<book> bookInformation() {
		List<book> books = dao.isData();
		return books;
	}

    @CrossOrigin(origins = "http://localhost:61458")
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping("api/update/book/{bookname}/{authorname}/{booktype}/{price}")
	public String bookInsertion(/* @PathVariable("id") int id */ @PathVariable("bookname") String bookname,
			@PathVariable("authorname") String authorname, @PathVariable("booktype") String booktype,
			@PathVariable("price") Double price) {
		book b = new book();
		// b.setId(id);
		b.setBookname(bookname);
		b.setAuthorname(authorname);
		b.setBooktype(booktype);
		b.setPrice(price);
		if (dao.savebook(b) == 1) {
			return "Successfully added to db";
		}
		return "failed to add";
	}
	
    @CrossOrigin(origins = "http://localhost:61458")
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping("api/del/book/{bookname}")
	public String deleteBookByName(@PathVariable("bookname") String bookname) {
		
		if(dao.deleteBookByName(bookname)==1) {
			return "deleted successfully";
		}
		return "no record found";
	}
	
	
}
