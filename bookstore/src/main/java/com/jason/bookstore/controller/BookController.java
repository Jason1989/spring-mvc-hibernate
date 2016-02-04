package com.jason.bookstore.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jason.bookstore.model.Book;
import com.jason.bookstore.service.BookService;


@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping("/listBooks.do")
	public String listBooks(Map<String, Object> map){
		map.put("book", new Book());
		map.put("bookList", bookService.listBooks());
		return "/book/listBooks";
	}
	
	@RequestMapping("/get/{bookId}.do")
	public String getBook(@PathVariable Long bookId, Map<String, Object> map){
		Book book = bookService.getBook(bookId);
		map.put("book", book);
		return "/book/bookForm";
	}
	
	@RequestMapping(value="/save.do", method = RequestMethod.POST)
	public String saveBook(@ModelAttribute("book") Book book, BindingResult result){
		bookService.saveBook(book);
		return "redirect:listBooks.do";
	}
	
	@RequestMapping("/delete/{bookId}.do")
	public String deleteBook(@PathVariable("bookId")Long id){
		bookService.deleteBook(id);
		return "redirect:/book/listBooks.do";
	}
}
