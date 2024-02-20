package com.works.controllers;

import com.works.entities.Customer;
import com.works.services.SignUpService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class SignUpController {

    final SignUpService signUpService;

    @GetMapping("")
    public String home() {
        return "signup";
    }

    @PostMapping("signup")
    public String signup(@Valid Customer customer, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getFieldErrors());
        }else {
            boolean status = signUpService.signup(customer);
            //return status == true ? "signup" : "error";
        }

        return "signup";
    }

}
