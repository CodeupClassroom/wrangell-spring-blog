package com.codeup.blog;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdsRepo extends CrudRepository<Ad, Long> {

}
