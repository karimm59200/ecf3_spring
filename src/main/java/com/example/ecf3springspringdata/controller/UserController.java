package com.example.ecf3springspringdata.controller;

import com.example.ecf3springspringdata.exception.UserExistException;
import com.example.ecf3springspringdata.exception.UserNotExistException;
import com.example.ecf3springspringdata.service.LoginService;
import com.example.ecf3springspringdata.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private HttpServletResponse response;

    @GetMapping("/form-sign-up")
    public String signUp() {
        return "registry";
    }

    @PostMapping("/signup")
    public String postsignUp(@RequestParam String name, @RequestParam String email, @RequestParam String password) throws UserExistException {
        if (userService.signUp(name, email, password)) {
            return "redirect:/user/sign-in";
        }
        return null;
    }

    @GetMapping("/sign-in")
    public ModelAndView signIn() {
        ModelAndView mv = new ModelAndView("sign-in");
        return mv;
    }

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("home");
        return mv;
    }

    @PostMapping("/sign-in")
    public String singIn(@RequestParam String email, @RequestParam String password) throws UserNotExistException {
        if (userService.signIn(email, password)) {
            System.out.println(email + " " + password);
            return "redirect:/user/home";
        }
        return null;
    }

}
