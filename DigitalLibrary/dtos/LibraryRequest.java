package com.finalProject.DigitalLibrary.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LibraryRequest {
    private int userId;
    private int bookId;
}
