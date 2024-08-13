package com.acciojob.library_system.Services;

import com.acciojob.library_system.Enum.TransactionStatus;
import com.acciojob.library_system.Models.Book;
import com.acciojob.library_system.Models.LibraryCard;
import com.acciojob.library_system.Models.Transaction;
import com.acciojob.library_system.Repositories.BookRepository;
import com.acciojob.library_system.Repositories.CardRepository;
import com.acciojob.library_system.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public String issueBook(int bookId,int cardId) throws Exception {

        //1. Get Book Entity from bookId
        Book book = bookRepository.findById(bookId).get();

        //2. Get CardEntity from cardId
        LibraryCard card = cardRepository.findById(cardId).get();

        //3. Create tThe txn Entity
        Transaction transaction = new Transaction();

        // FAILURE : if the book is issued
        if(book.getIsIssued()) {
            throw new Exception("Book is already issued");
        }

        //FAILURE : noOfBooksIssued in card has reached the Limit
        if(card.getNoOfBooksIssued()==3){
            throw new Exception("Card Book issue Limit is reached");
        }

        //SUCCESS
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        //Set Foreign Key entities (Book and Card)
        transaction.setBook(book);
        transaction.setCard(card);

        //set book to isIssued : True
        book.setIsIssued(true);

        //Set card : noOfBooksIssued + 1
        card.setNoOfBooksIssued(card.getNoOfBooksIssued()+1);

        transaction = transactionRepository.save(transaction);
        bookRepository.save(book);
        cardRepository.save(card);

        return "The transaction is saved with transactionId : "+transaction.getTransactionId();
    }
}
