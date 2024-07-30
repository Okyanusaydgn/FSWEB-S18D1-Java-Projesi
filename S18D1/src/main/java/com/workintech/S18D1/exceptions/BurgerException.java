package com.workintech.S18D1.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;


@Getter
@Setter
public class BurgerException extends RuntimeException {

    private HttpStatus httpStatus;
    public BurgerException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
