package com.capcom.mh.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ItemExistException extends RuntimeException{

    public ItemExistException(String message) {
        super(message);
    }
}
