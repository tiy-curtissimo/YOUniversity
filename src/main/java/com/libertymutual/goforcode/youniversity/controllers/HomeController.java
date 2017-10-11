package com.libertymutual.goforcode.youniversity.controllers;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.libertymutual.goforcode.youniversity.models.User;
import com.libertymutual.goforcode.youniversity.repositories.UserRepository;

@RestController
@RequestMapping("/")
public class HomeController {

    private UserRepository userRepository;
    private PasswordEncoder encoder;

    public HomeController(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }    

}
