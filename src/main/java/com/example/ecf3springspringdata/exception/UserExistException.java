package com.example.ecf3springspringdata.exception;

public class UserExistException extends Exception{
    public UserExistException() {
        super("User Exist");
    }
}
