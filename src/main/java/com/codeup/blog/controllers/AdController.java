package com.codeup.blog.controllers;

import com.codeup.blog.Ad;
import com.codeup.blog.services.AdsSvc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdController {

    private AdsSvc adsSvc;
    // Dependency injection is happening
    public AdController(AdsSvc adsSvc){
        this.adsSvc = adsSvc;
    }

    //    GET	/ads	ads index page
    @GetMapping("/ads")
    public String adsIndex(Model vModel) {
        vModel.addAttribute("ads", adsSvc.findAll());
        return "ads/index";
    }

//    GET	/ads/{id}	view an individual post
    @GetMapping("/ads/{id}")
    public String individualAd(@PathVariable int id, Model vModel) {
        vModel.addAttribute("ad", adsSvc.findOne(id));
        return "ads/show";
    }

//    GET	/ads/create	view the form for creating a post
    @GetMapping("/ads/create")
    @ResponseBody
    public String sendAdForm() {
        return "view the form for creating an ad";
    }

//    POST	/ads/create	create a new post
    @PostMapping("/ads/create")
    @ResponseBody
    public String createAd() {
        return "create a new post";
    }

}
