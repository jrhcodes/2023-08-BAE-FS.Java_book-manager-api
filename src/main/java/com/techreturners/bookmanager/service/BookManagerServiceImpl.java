package com.techreturners.bookmanager.service;

import com.techreturners.bookmanager.model.Book;
import com.techreturners.bookmanager.repository.BookManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookManagerServiceImpl implements BookManagerService {

    @Autowired
    BookManagerRepository bookManagerRepository;

    @Override
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        bookManagerRepository.findAll().forEach(books::add);
        return books;
    }

    @Override
    public Book insertBook(Book book) {
        return bookManagerRepository.save(book);
    }

    @Override
    public Book getBookById(Long id) {
        return bookManagerRepository.findById(id).orElse(null);
    }

    //User Story 4 - Update Book By Id Solution
    @Override
    public void updateBook(Book book) {
        Optional<Book> retrievedBook = bookManagerRepository.findById(book.getId());

        if( retrievedBook.isPresent()) {
            bookManagerRepository.save(book);
        }
    }

    @Override
    public void deleteBookById(Long id) {
        bookManagerRepository.deleteById(id);
    }
}
