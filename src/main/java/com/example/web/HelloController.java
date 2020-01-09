package com.example.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HelloController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String get() {
        return "hello" + new Date();
    }
}
