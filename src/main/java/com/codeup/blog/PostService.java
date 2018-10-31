package com.codeup.blog;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private List<Post> posts;

    public PostService() {
        posts = new ArrayList<>();

        posts.add(new Post("Halloween", "Michael Myers"));
        posts.add(new Post("Friday 13th", "Jason Voorhees"));
        posts.add(new Post("Nightmare on Elm Street", "Freddy Krueger"));
        posts.add(new Post("IT", "Pennywise"));
        posts.add(new Post("Saw", "Jigsaw"));
        posts.add(new Post("Charlie Brown", "The Great Pumpkin"));
        posts.add(new Post("Poltergeist", "They're heeeeerre"));
    }

    public List<Post> findAll() {
        return posts;
    }

    public Post findOne(int id) {
        return posts.get(id - 1);
    }

}
