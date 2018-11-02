package com.codeup.blog.controllers;

import com.codeup.blog.models.Category;
import com.codeup.blog.services.CategoriesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CategoriesController {

    @Autowired
    private CategoriesRepo categoriesRepo;

    @GetMapping("/categories/{id}")
    public String showAdsByCategory(@PathVariable long id, Model vModel){
        Category cat = categoriesRepo.findOne(id);
        vModel.addAttribute("ads", cat.getAds());
        return "ads/index";
    }

}
