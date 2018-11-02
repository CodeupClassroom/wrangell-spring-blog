package com.codeup.blog.services;

import com.codeup.blog.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepo extends CrudRepository<Category, Long> {
}
