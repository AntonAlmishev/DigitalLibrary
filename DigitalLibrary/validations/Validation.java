package com.finalProject.DigitalLibrary.validations;

import com.finalProject.DigitalLibrary.repository.CommonRepository;
import com.finalProject.DigitalLibrary.exeptions.InvalidException;
import org.springframework.stereotype.Component;

import static com.finalProject.DigitalLibrary.messages.ExceptionMessages.*;

@Component
public class Validation {
    private final CommonRepository commonRepository;

    public Validation(CommonRepository commonRepository) {
        this.commonRepository = commonRepository;
    }

    public void passwordValidation(String password,String repeatPassword){
        if(!(password.equals(repeatPassword))){
            throw new InvalidException(PASSWORD_DONT_MATCH);
        }
        boolean containsDigit=false;
        for(char c :password.toCharArray()){
            if(Character.isDigit(c)){
                containsDigit=true;
            }
        }
        if(!containsDigit){
            throw new InvalidException(PASSWORD_SHOULD_HAVE_DIGIT);
        }
        else if(password.length()<3){
            throw new InvalidException(PASSWORD_SHOULD_BE_MIN_3_SYMBOLS);
        }
    }

    public void checkIfUsernameExists(String username){
        if(commonRepository.findUserByUsername(username).isPresent()){
            throw new InvalidException(USERNAME_ALREADY_EXIST);
        }
    }

    public void changeUsernameWithTheSameValidation(String newUsername,String oldUsername){
        if(newUsername.equals(oldUsername)){
            throw new InvalidException(CHANGE_USERNAME_WITH_THE_SAME_ONE);
        }

    }
}
