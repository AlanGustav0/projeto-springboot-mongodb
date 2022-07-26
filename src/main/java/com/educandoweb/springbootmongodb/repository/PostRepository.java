package com.educandoweb.springbootmongodb.repository;

import com.educandoweb.springbootmongodb.domain.Post;
import com.educandoweb.springbootmongodb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PostRepository extends MongoRepository<Post,String> {

    @Query("{'title': { $regex: ?0, $options: 'i'} }")
    List<Post> findByTitle(String text);

    List<Post> findByTitleContainingIgnoreCase(String text);
}
