package com.libertymutual.goforcode.youniversity.controllers;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.libertymutual.goforcode.youniversity.models.User;
import com.libertymutual.goforcode.youniversity.repositories.UserRepository;

@RequestMapping("/user")
@RestController
public class UserController {

    private UserRepository userRepository;
    private PasswordEncoder encoder;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("")
    public User getUser(User user) {
        String username = user.getUsername();
        return userRepository.findByUsername(username);
    }

    @PutMapping("")
    public User updateUser(User user) {
        String username = user.getUsername();
        userRepository.findByUsername(username);
        return userRepository.save(user);
    }

    @PostMapping("create")
    public ModelAndView createUser(User user) {
        String password = user.getPassword();
        String encryptedPassword = encoder.encode(password);
        user.setPassword(encryptedPassword);

        ModelAndView mv = new ModelAndView();
        try {
            userRepository.save(user);
            mv.addObject("sucessMessage", "Success");
        } catch (DataIntegrityViolationException dive) {
            mv.addObject("errorMessage", "Cannot create user with that username");
        }
        return mv;
    }

}
