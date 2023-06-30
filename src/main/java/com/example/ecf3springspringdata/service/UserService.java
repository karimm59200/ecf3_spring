package com.example.ecf3springspringdata.service;


import com.example.ecf3springspringdata.entity.User;
import com.example.ecf3springspringdata.exception.UserExistException;
import com.example.ecf3springspringdata.exception.UserNotExistException;
import com.example.ecf3springspringdata.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserRepository userRepository;

    public boolean signUp(String name, String password, String email) throws UserExistException {
        try{ userRepository.findByEmail(email);
            throw new UserExistException();
    } catch (Exception ex) {
            User user = User.builder().name(name).password(password).email(email).build();
            userRepository.save(user);
            return user.getId() > 0;
        }
    }

   public boolean signIn(String email, String password) throws UserNotExistException {
        try {
            User user = userRepository.findByEmailAndPassword(email, password);
            System.out.println(email + " " + password);
            return loginService.login(user);
        } catch (Exception ex) {
            throw new UserNotExistException();
        }
    }


}
