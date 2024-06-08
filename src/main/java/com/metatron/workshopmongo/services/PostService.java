package com.metatron.workshopmongo.services;

import com.metatron.workshopmongo.domain.Post;

import com.metatron.workshopmongo.repository.PostRepository;

import com.metatron.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;


    public Post findById(String id) {
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("objeto não encontrado"));
    }


}