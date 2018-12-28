package com.vizer.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vizer.library.entities.Book;

public interface BookRepo extends JpaRepository<Book, Long> {

}
