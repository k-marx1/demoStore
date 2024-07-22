package com.demostore.services;

import com.demostore.models.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book getBookById(Long id);

    Book getBookByName(String name);

    Book saveBook(Book book);

    void deleteBook(Long id);
}
