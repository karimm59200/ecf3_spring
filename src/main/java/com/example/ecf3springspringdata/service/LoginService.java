package com.example.ecf3springspringdata.service;
import com.example.ecf3springspringdata.entity.User;


public interface LoginService {

    public boolean login(User user);
    public boolean isLogged();

    public boolean isAdmin();

    public int getUserId();

    public String getName();

}
