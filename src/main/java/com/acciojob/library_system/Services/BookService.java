package com.acciojob.library_system.Services;


import com.acciojob.library_system.Models.Author;
import com.acciojob.library_system.Models.Book;
import com.acciojob.library_system.Repositories.AuthorRepository;
import com.acciojob.library_system.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service

public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public String addBook(Book book) {
        book = bookRepository.save(book);
        return "Book has been saved to the DB with bookId "+book.getBookId();
    }

    public String associateBookAndCard(Integer bookId,Integer authorId) throws Exception{

        Optional<Book> optionalBook = bookRepository.findById(bookId);

        if(optionalBook.isEmpty()) {
            throw new Exception("Entered bookId is invalid");
        }

        Optional<Author> optionalAuthor = authorRepository.findById(authorId);

        if(optionalAuthor.isEmpty()) {
            throw new Exception("Entered AuthorId is invalid");
        }

        Book book = optionalBook.get();
        Author author = optionalAuthor.get();

        book.setAuthor(author);
        author.setNoOfBooks(author.getNoOfBooks()+1);

        bookRepository.save(book);
        authorRepository.save(author);

        return "Book and author have been associated";
    }

}