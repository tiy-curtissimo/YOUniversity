package com.libertymutual.goforcode.youniversity.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.libertymutual.goforcode.youniversity.models.User;
import com.libertymutual.goforcode.youniversity.repositories.UserRepository;

@Controller
@RequestMapping("/")
public class HomeController {

    private UserRepository userRepository;
    private PasswordEncoder encoder;

    public HomeController(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @GetMapping("")
    public String home() {
        return "home/default";
    }

    @GetMapping("login-page")
    public String login() {
        return "home/login-page";
    }

    @GetMapping("signup")
    public String signup() {
        return "home/signup";
    }

    @PostMapping("signup")
    public ModelAndView handleSignup(User user) {
        String password = user.getPassword();
        String encryptedPassword = encoder.encode(password);
        user.setPassword(encryptedPassword);

        ModelAndView mv = new ModelAndView();
        try {
            userRepository.save(user);
            mv.setViewName("redirect:/login-page");
        } catch (DataIntegrityViolationException dive) {
            mv.setViewName("home/signup");
            mv.addObject("errorMessage", "Cannot signup with that username");
        }
        return mv;
    }

}
