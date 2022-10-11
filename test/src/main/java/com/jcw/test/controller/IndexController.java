package com.jcw.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

    @GetMapping("/join")
    public String join(){
        System.out.println("pass");
        return "join";
    }

    @GetMapping("/login")
    public String login(){
        System.out.println("pass");
        return "login";
    }
}
