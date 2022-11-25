package com.finalProject.DigitalLibrary.repositoryInterfaces;

import com.finalProject.DigitalLibrary.models.Book;

import java.util.Optional;

public interface AuthorInterface {
    public Double showRateForBookByBookId(int bookId);
    public Integer countHowMuchBookIsRead(int bookId);
    public String insertFile(String fileName);
    public Integer insertBook(Book book);
    public String updateBookStatus(boolean isActive, int bookId);
    public String deleteBookById(int bookId);
    public Optional<Boolean> checkIfBookIdExist(int bookId);
    public Optional<String> bookStatusValue(int bookId);
    public Optional<String> getAuthorNameByBookId(int bookId);
    public void insertGenre(int bookId,String genreName);
}
