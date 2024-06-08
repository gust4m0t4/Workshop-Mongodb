package com.metatron.workshopmongo.repository;

import com.metatron.workshopmongo.domain.Post;
import com.metatron.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
