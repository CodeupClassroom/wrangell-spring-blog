package com.codeup.blog.controllers;

import com.codeup.blog.models.Ad;
import com.codeup.blog.models.User;
import com.codeup.blog.services.AdsSvc;
import com.codeup.blog.services.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdController {

    private AdsSvc adsSvc;

    @Autowired
    private UserRepo userRepo;

    // Dependency injection is happening
    public AdController(AdsSvc adsSvc){
        this.adsSvc = adsSvc;
    }

    //    GET	/ads	ads index page
    @GetMapping("/ads")
    public String adsIndex(Model vModel) {
        vModel.addAttribute("ads", adsSvc.all());
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
    public String showAdForm(Model vModel) {
        vModel.addAttribute("ad", new Ad());
        return "ads/create";
    }

//    POST	/ads/create	create a new post
    @PostMapping("/ads/create")
    public String createAd(@ModelAttribute Ad ad) {
        ad.setUser(userRepo.findOne(1L));
        Ad savedAd = adsSvc.create(ad);
        return "redirect:/ads/" + savedAd.getId();
    }

    //    GET	/ads/update	view the form for updating a post
    @GetMapping("/ads/{id}/update")
    public String showAdUpdateForm(@PathVariable int id, Model vModel) {
        vModel.addAttribute("ad", adsSvc.findOne(id));
        return "ads/update";
    }

    @PostMapping("/ads/{id}/update")
    public String showAdUpdateForm(@ModelAttribute Ad ad) {
        Ad updatedAd = adsSvc.update(ad);
        return "redirect:/ads/" + updatedAd.getId();
    }

    @GetMapping("/ads/search/{term}")
    public String showResults(@PathVariable String term, Model vModel){
        vModel.addAttribute("ads", adsSvc.search(term));
        return "ads/index";
    }

//    @GetMapping("/create/user")
//    public void createDummyUser(){
//        userRepo.save(new User("fer","fer@mail.com","pass"));
//    }

}
