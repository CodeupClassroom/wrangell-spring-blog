package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/add/{x}/and/{y}")
    @ResponseBody
    public String add(@PathVariable int x, @PathVariable int y) {
        Integer sum = x + y;
        return sum.toString();
    }

    @GetMapping("/subtract/{x}/from/{y}")
    @ResponseBody
    public String subtract(@PathVariable int x, @PathVariable int y) {
        Integer diff = x - y;
        return diff.toString();
    }

    @GetMapping("/multiply/{x}/and/{y}")
    @ResponseBody
    public Double multiply(@PathVariable double x, @PathVariable double y) {
        Double product = x * y;
        return product;
    }

    @GetMapping("/divide/{x}/by/{y}")
    @ResponseBody
    public Double divide(@PathVariable double x, @PathVariable double y) {
        Double quotient = x / y;
        return quotient;
    }
}
