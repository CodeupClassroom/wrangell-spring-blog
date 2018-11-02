package com.codeup.blog.services;

import com.codeup.blog.models.Ad;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdsSvc {

    private AdsRepo adsRepo;

    public AdsSvc(AdsRepo adsRepo){
        this.adsRepo = adsRepo;
    }

    // Def service
    public Iterable<Ad> all(){
        // All the ads from DB
        return adsRepo.findAll();
    }

    public Ad create(Ad ad){
        return adsRepo.save(ad);
    }

    public Ad update(Ad ad){
        return adsRepo.save(ad);
    }

    public Ad findOne(long id){
        return adsRepo.findOne(id);
    }

    public List<Ad> search(String term){
//        return adsRepo.findAllByTitleContainsOrDescriptionContains(term, term);
        return adsRepo.searchByTitleOrDesc(term);
    }

}
