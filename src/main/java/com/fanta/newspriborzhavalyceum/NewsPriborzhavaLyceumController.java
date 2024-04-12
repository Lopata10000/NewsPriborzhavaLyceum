package com.fanta.newspriborzhavalyceum;

import com.fanta.newspriborzhavalyceum.database.entity.User;
import com.fanta.newspriborzhavalyceum.database.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.stereotype.Controller
public class NewsPriborzhavaLyceumController {

    @GetMapping("/home")
    public String showHomeForm() {
        return "home";
    }

    @GetMapping("/resources")
    public String showResourcesForm() {
        return "resources";
    }


    @GetMapping("/sign-up")
    public String showSignUpForm() {
        return "sign-up";
    }


    @GetMapping("/log-in")
    public String showLogInForm() {
        return "log-in";
    }


    @GetMapping("/reset-password")
    public String showResetPasswordForm() {
        return "reset-password";
    }


}
