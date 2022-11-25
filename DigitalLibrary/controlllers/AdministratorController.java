package com.finalProject.DigitalLibrary.controlllers;

import com.finalProject.DigitalLibrary.dtos.StatusRequest;
import com.finalProject.DigitalLibrary.services.AdministratorService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdministratorController {

    private final AdministratorService administratorService;

    public AdministratorController(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/change/status")
    @PreAuthorize("hasRole('ADMIN')")
    public String changeUserStatus(@RequestBody StatusRequest statusRequest) {
        return administratorService.changeUserStatus(statusRequest.getIsActive(),statusRequest.getUserId());
    }

}



