package com.example.ecf3springspringdata.exception;

public class UserNotExistException extends Exception{
    public UserNotExistException() {
        super("User Not Exist");
    }
}
