package com.example.demo.security.Utils;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;
import java.util.regex.Pattern;

//Basic regex in order to find is sentence contain @

@Service
public class EmailValidator implements Predicate<String> {
    @Override
    public boolean test(String s) {
        Pattern pattern= Pattern.compile("^(.+)@(.+)$");
        return pattern.matcher(s).matches();
    }
}
