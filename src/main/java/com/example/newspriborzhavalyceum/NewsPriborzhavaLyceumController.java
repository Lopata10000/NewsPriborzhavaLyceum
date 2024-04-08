package com.example.newspriborzhavalyceum;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class NewsPriborzhavaLyceumController {


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
