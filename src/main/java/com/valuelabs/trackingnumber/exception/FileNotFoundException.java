package com.valuelabs.trackingnumber.exception;

import org.springframework.http.HttpStatus;

public class FileNotFoundException extends RuntimeException{

    private String message;

    FileNotFoundException(String message){
        super(message);
        this.message = message;
    }
}
