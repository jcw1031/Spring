package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

    @GetMapping("hello") //Web Application에서 /hello라고 들어오면 아래 메서드를 호출
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello"; //.../resources/templates/hello.html 반환(실행)
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){ //외부에서 파라미터를 받아 옴 (http://localhost:8080/hello-mvc?name=[value])
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //http에서의 body부분에 이 데이터를 직접 넣겠다는 의미 (뷰가 필요 없음)
    public String helloString(@RequestParam("name") String name){
        return "hello "+ name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name, @RequestParam("age") int age){
        Hello hello = new Hello();
        hello.setName(name);
        hello.setAge(age);
        return hello;
    }

    static class Hello{
        private String name;
        private int age;

        public String getName(){
            return this.name;
        }

        public void setName(String name){
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}