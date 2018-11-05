package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ViewsLecture {

    @GetMapping("/hello/{name}")
    public String showHello(@PathVariable String name, Model viewModel){
        name = (name != null) ? name.toUpperCase() : "Invalid name";
        viewModel.addAttribute("name", name);
        return "hello";
    }

//    @GetMapping("/users/{role}")
//    public String showUsers(@PathVariable String role,Model vModel){
//
//        List<String> users = new ArrayList<>();
//        users.add("Fer");
//        users.add("Daniel");
//        users.add("Ryan");
//        users.add("Justin");
//
//        vModel.addAttribute("users", users);
//        vModel.addAttribute("role", role);
//
//        return "users";
//
//    }


}
