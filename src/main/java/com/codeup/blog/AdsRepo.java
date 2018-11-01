package com.codeup.blog;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdsRepo extends CrudRepository<Ad, Long> {
    //select * from ads where title like '%X%' or description like '%Y%';
    List<Ad> findAllByTitleContainsOrDescriptionContains(String str, String str2);

    //HQL
    @Query("from Ad where title like %?1% or description like %?1%")
    List<Ad> searchByTitleOrDesc(String term);
}
