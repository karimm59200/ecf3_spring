package com.example.ecf3springspringdata.service;


import com.example.ecf3springspringdata.entity.User;
import com.example.ecf3springspringdata.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserRepository userRepository;

    public boolean signUp(String name, String password, String email) {
        if (userRepository.findByName(name) != true) {
            return false;
        }
        userRepository.save(new User(name, password, email));
        return true;
    }

    public boolean signIn(String name, String password) {
        User user = userRepository.findByNameAndPassword(name, password);
        if (user == null) {
            return false;
        }
        return loginService.login(user);
    }
}
