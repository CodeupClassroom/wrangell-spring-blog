package com.codeup.blog.controllers;

import com.codeup.blog.Ad;
import com.codeup.blog.services.AdsSvc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String showAdForm(Model vModel) {
        vModel.addAttribute("ad", new Ad());
        return "ads/create";
    }

//    POST	/ads/create	create a new post
    @PostMapping("/ads/create")
    public String createAd(@ModelAttribute Ad ad) {
        Ad savedAd = adsSvc.save(ad);
        return "redirect:/ads/" + savedAd.getId();
    }

    //    GET	/ads/create	view the form for creating a post
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

}
