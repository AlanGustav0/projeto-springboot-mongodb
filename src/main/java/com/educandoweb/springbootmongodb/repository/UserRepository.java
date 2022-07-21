package com.educandoweb.springbootmongodb.repository;

import com.educandoweb.springbootmongodb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
}
