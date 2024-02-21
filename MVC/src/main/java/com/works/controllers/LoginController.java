package com.works.controllers;

import com.works.entities.Customer;
import com.works.services.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {

    final LoginService loginService;

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @PostMapping("customerLogin")
    public String customerLogin(Customer customer) {
        boolean status = loginService.login(customer);
        return status == true ? "redirect:dashboard" : "login";
    }

}
