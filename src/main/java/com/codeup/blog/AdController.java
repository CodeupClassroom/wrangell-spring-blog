package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdController {

    List<Ad> ads = new ArrayList<>();

    public AdController(){
        ads.add(new Ad("My first ad", "It's about my feelings"));
    }

    //    GET	/ads	ads index page
    @GetMapping("/ads")
    public String adsIndex(Model vModel) {
        ads.add(new Ad("A good day", "Yay"));
        ads.add(new Ad("A bad day", "Meh"));
        vModel.addAttribute("ads", ads);
        return "ads/index";
    }

//    GET	/ads/{id}	view an individual post
    @GetMapping("/ads/{id}")
    public String individualAd(@PathVariable int id, Model vModel) {
        vModel.addAttribute("ad", ads.get(id-1));
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
