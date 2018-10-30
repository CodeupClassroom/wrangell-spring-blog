package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
//
//    @GetMapping("/hello/{name}")
//    @ResponseBody
//    private String sayHello(@PathVariable String name) {
//        return "Hello " + name + "!";
//    }
}