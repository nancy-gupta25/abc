package com.nancy.springboot.firsttask.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nancy.springboot.firsttask.model.Book;

@Service
public class BookDao {

	List<Book> bookarr;

	public BookDao() {
		bookarr = new ArrayList<Book>();

		bookarr.add(new Book(1, "SpringBoot Restful", "abc", 2));
		bookarr.add(new Book(2, "SpringBoot microservices", "abc", 1));
		bookarr.add(new Book(3, "SpringBoot MVC", "abc", 5));
	}

	public boolean addBook(Book b) {
		this.bookarr.add(b);
		return true;
	}

	public Book getBook(int bookid) {

		Book book = bookarr.stream().filter((b) -> {
			return b.getBookId() == bookid;
		}).findFirst().orElse(null);

		System.out.println(book);
		return book;

	}

	public int removeBook(Book b) {

		boolean status = this.bookarr.remove(b);

		if (status)
			return b.getBookId();
		else
			return -1;
	}

	public List<Book> getAllBooks() {
		return this.bookarr;
	}
}
