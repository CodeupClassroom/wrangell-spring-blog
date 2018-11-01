package com.codeup.blog;

import com.codeup.blog.services.PostRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
//    private List<Post> posts;
    private PostRepository postRepo;

    public PostService(PostRepository postRepo) {
        this.postRepo = postRepo;
        //        posts = new ArrayList<>();
//
//        posts.add(new Post("Halloween", "Michael Myers"));
//        posts.add(new Post("Friday 13th", "Jason Voorhees"));
//        posts.add(new Post("Nightmare on Elm Street", "Freddy Krueger"));
//        posts.add(new Post("IT", "Pennywise"));
//        posts.add(new Post("Saw", "Jigsaw"));
//        posts.add(new Post("Charlie Brown", "The Great Pumpkin"));
//        posts.add(new Post("Poltergeist", "They're heeeeerre"));
    }

    public Iterable<Post> findAll() {

        return postRepo.findAll();
    }

    public Post findOne(long id) {

        return postRepo.findOne(id);
    }

    public Post edit(Post post) {
        return postRepo.save(post);
    }

    public void delete(long id) {
        postRepo.delete(id);
    }

}
