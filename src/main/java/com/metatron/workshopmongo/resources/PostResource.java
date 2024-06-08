package com.metatron.workshopmongo.resources;

import com.metatron.workshopmongo.domain.Post;
import com.metatron.workshopmongo.domain.User;
import com.metatron.workshopmongo.dto.UserDTO;
import com.metatron.workshopmongo.services.PostService;
import com.metatron.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.metatron.workshopmongo.resources.util.URL;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;



@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService services;



    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = services.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/fullsearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate) {
        text = URL.decodeParam(text);
        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date());

        List<Post> list = services.fullSearch(text, min, max);


        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> list = services.findByTitle(text);


        return ResponseEntity.ok().body(list);
    }

}