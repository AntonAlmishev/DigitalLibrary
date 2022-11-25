package com.finalProject.DigitalLibrary.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequest {
    private String userName;
    private String userPassword;
    private String passwordConfirmation;
    private String roleName;
}
