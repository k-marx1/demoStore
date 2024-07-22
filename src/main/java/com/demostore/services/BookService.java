package com.demostore.services;

import com.demostore.models.Book;

import java.util.List;

public interface BookService {
    public List<Book> getAllBooks();

    public Book getBookById(Long id);

    public Book getBookByName(String name);

    public Book saveBook(Book book);

    public void deleteBook(Long id);

    public Book editBook(Long id, Book book);
}
