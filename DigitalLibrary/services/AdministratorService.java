package com.finalProject.DigitalLibrary.services;

import com.finalProject.DigitalLibrary.repository.AdministratorRepository;
import com.finalProject.DigitalLibrary.exeptions.InvalidException;
import org.springframework.stereotype.Service;

import static com.finalProject.DigitalLibrary.messages.ExceptionMessages.INVALID_USER_ID;
import static com.finalProject.DigitalLibrary.messages.OutputMessages.SAME_STATUS;

@Service
public class AdministratorService {

    private final AdministratorRepository administratorRepository;

    public AdministratorService(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    public String changeUserStatus(Boolean isActive, int userId){

        administratorRepository.checkIfUserIdExist(userId)
                        .orElseThrow(() -> new InvalidException(INVALID_USER_ID));

        String status="0";
        if(isActive)status="1";

        if(status.equals(administratorRepository.userStatusValue(userId).get())){
            return SAME_STATUS;
        }

        return administratorRepository.updateUserStatus(isActive,userId);
    }


}