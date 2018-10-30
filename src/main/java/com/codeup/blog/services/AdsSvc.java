package com.codeup.blog.services;

import com.codeup.blog.Ad;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdsSvc {
    private List<Ad> ads;

    public AdsSvc(){
        ads = new ArrayList<>();
        createAds();
    }

    public List<Ad> findAll(){
        return ads;
    }

    public Ad save(Ad ad){
        ad.setId(ads.size() + 1);
        ads.add(ad);
        return ad;
    }

    public Ad findOne(long id){
       return ads.get( (int) id - 1);
    }

    private void createAds(){
        this.save(new Ad("My first ad", "It's about my feelings"));
        this.save(new Ad("A good day", "Yay"));
        this.save(new Ad("A bad day", "Meh"));
    }

}
