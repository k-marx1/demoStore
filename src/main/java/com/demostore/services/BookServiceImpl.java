package com.demostore.services;

import com.demostore.models.Book;
import com.demostore.repostirories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public Book getBookByName(String name) {
        return new Book();
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book editBook(Long id, Book book) {
        Book existingBook = bookRepository.findById(id).get();

        existingBook.setName(book.getName());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setReleaseYear(book.getReleaseYear());
        existingBook.setPrice(book.getPrice());

        bookRepository.save(existingBook);

        return existingBook;
    }
}
