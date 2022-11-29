package com.nancy.springboot.firsttask.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.nancy.springboot.firsttask.dao.BookDao;
import com.nancy.springboot.firsttask.model.Book;

@Controller
public class BookController {

	@Autowired
	BookDao bookdao;

	@GetMapping("/getbook/{bookid}")
	public String getBook(@PathVariable int bookid, ModelMap model) {
		Book b = this.bookdao.getBook(bookid);
		System.out.println("inside book");
		if (b!= null) {
			model.addAttribute("book", b);
			return "book";
		} else {
			model.addAttribute("message","this bookId " + bookid + " is not found");
			return "book";
		}
		
	}
}