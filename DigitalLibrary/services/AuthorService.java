package com.finalProject.DigitalLibrary.services;

import com.finalProject.DigitalLibrary.models.Book;
import com.finalProject.DigitalLibrary.repository.AuthorRepository;
import com.finalProject.DigitalLibrary.exeptions.InvalidException;
import org.springframework.stereotype.Service;

import static com.finalProject.DigitalLibrary.messages.ExceptionMessages.INVALID_BOOK_ID;
import static com.finalProject.DigitalLibrary.messages.OutputMessages.*;

@Service
public class AuthorService {


    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Double getRateForBookById(int bookId) {
        authorRepository.checkIfBookIdExist(bookId)
                .orElseThrow(()->new InvalidException(INVALID_BOOK_ID));
        return authorRepository.showRateForBookByBookId(bookId);
    }

    public Integer getBookNumberOfTimesReadById(int bookId) {
        authorRepository.checkIfBookIdExist(bookId)
                .orElseThrow(()->new InvalidException(INVALID_BOOK_ID));
        return authorRepository.countHowMuchBookIsRead(bookId);
    }

    public String createFile(String fileName) {
        return authorRepository.insertFile(fileName);
    }


    public Integer createBook(Book book) {
        return authorRepository.insertBook(book);
    }

    public String changeBookStatus(Boolean isActive, int bookId) {
        authorRepository.checkIfBookIdExist(bookId)
                        .orElseThrow(()->new InvalidException(INVALID_BOOK_ID));
    String status="0";
    if(isActive)status="1";

    if(authorRepository.bookStatusValue(bookId).isPresent() && status.equals(authorRepository.bookStatusValue(bookId).get())){
        return SAME_STATUS;
    }
        return authorRepository.updateBookStatus(isActive, bookId);
    }


    public String removeBookById(int bookId){
        authorRepository.checkIfBookIdExist(bookId)
                        .orElseThrow(()->new InvalidException(INVALID_BOOK_ID));
        return authorRepository.deleteBookById(bookId);
    }

    public String getBookAuthorName(int bookId){
        authorRepository.checkIfBookIdExist(bookId)
                .orElseThrow(()->new InvalidException(INVALID_BOOK_ID));
        if(authorRepository.getAuthorNameByBookId(bookId).isPresent()){
            return authorRepository.getAuthorNameByBookId(bookId).get();
        }
        return "";
    }

    public void addGenre(int bookId,String genreName){
          authorRepository.insertGenre(bookId, genreName);
    }

}