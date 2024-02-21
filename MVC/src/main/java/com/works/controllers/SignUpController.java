package com.works.controllers;

import com.works.entities.Customer;
import com.works.services.SignUpService;
import com.works.services.TinkEncDec;
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
    final TinkEncDec tinkEncDec;

    @GetMapping("")
    public String home() {

        String cipherText = tinkEncDec.encrypt("12345");
        System.out.println(cipherText);

        String oldCipher = "w7fDnsKLOhvDnQ/DjybDgyHDg8OrwojDu8O4w7TDksKew5xtczLDkDzDusKYw5E/NgF0Mw==";
        String plainText = tinkEncDec.decrypt(oldCipher);
        System.out.println(plainText);

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
