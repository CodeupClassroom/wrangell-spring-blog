package com.codeup.blog.services;

import com.codeup.blog.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
