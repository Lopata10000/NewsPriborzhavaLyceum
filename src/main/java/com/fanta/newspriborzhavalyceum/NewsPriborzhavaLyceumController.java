package com.fanta.newspriborzhavalyceum;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class NewsPriborzhavaLyceumController {

    @GetMapping("/home")
    public String showHomeForm() {
        return "html/home";
    }

    @GetMapping("/resources")
    public String showResourcesForm() {
        return "html/resources";
    }


    @GetMapping("/sign-up")
    public String showSignUpForm() {
        return "html/sign-up";
    }


    @GetMapping("/log-in")
    public String showLogInForm() {
        return "html/log-in";
    }


    @GetMapping("/reset-password")
    public String showResetPasswordForm() {
        return "static/html/reset-password";
    }


}
