package com.vizer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vizer.library.entities.Book;
import com.vizer.library.repositories.BookRepo;
import com.vizer.plasticube.entities.User;
import com.vizer.plasticube.repositories.UserRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookTest {
	@Autowired
	UserRepo userRepo;
	@Autowired
	BookRepo bookRepo;
	@Test
	public void contextLoads() {
		List<Book> books = new ArrayList<Book>();
		User user = userRepo.getByUsername("vizer");
		Date utilDate = new Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		Book book = new Book("123", "BOOK AAA", "Author AAA", "Publishing By A Co.", (float) 12.2, "discriptionA", sqlDate, user);
		books.add(book);
		Book book2 = new Book("456", "BOOK BBB", "Author BBB", "Publishing By B Co.", (float) 13.3, "discriptionB", sqlDate, user);
		books.add(book2);
		
		bookRepo.saveAll(books);
	}
}
