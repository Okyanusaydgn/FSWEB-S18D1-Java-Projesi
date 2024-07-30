package com.workintech.S18D1.util;

import com.workintech.S18D1.exceptions.BurgerException;
import org.springframework.http.HttpStatus;

public class BurgerValidation {

    public static void checkName(String name) {
        if(name == null || name.isEmpty()){
            throw  new BurgerException("name is null or empty!" + name, HttpStatus.BAD_REQUEST);
        }
    }
}
