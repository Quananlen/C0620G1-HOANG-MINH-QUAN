package com.giga.service;

import org.springframework.stereotype.Service;

@Service
public class Email implements IEmail{

    @Override
    public String validate(String email) {
        String regex = "^\\w+@\\w+\\.\\w{2,3}$";
        String result = "not match";
        if (email.matches(regex)) result = "match";
        return result;
    }
}
