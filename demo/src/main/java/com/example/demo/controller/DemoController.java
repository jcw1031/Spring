package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {

    @GetMapping("hello") //Web Application에서 /hello라고 들어오면 아래 메서드를 호출
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello"; //.../resources/templates/hello.html 반환(실행)
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "demo";
    }
}