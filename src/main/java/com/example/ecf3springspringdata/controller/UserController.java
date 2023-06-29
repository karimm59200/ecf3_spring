package com.example.ecf3springspringdata.controller;

import com.example.ecf3springspringdata.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletResponse response;

    @GetMapping("/form-sign-up")
    public String signUp() {
        return "registry";
    }

    @PostMapping("/signup")
    public String signUp(@RequestParam (name = "name")  String name,
                         @RequestParam  String password,
                         @RequestParam  String email ) {
        if (userService.signUp(name, password, email)) {
            return "redirect:/user/sign-in";
        }
        return null;
    }

    @GetMapping("/sign-in")
    public ModelAndView signIn() {
        ModelAndView mv = new ModelAndView("sign-in");
        return mv;
    }

    @PostMapping("/post-sign-in")
    public String postSignIn(@RequestParam String name, @RequestParam String password) {
        if (userService.signIn(name, password)) {
            return "redirect:/user/home";
        }
        return null;
    }


}
