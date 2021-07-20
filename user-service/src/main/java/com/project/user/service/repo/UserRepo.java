package com.project.user.service.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.user.service.entity.User;

public interface UserRepo extends MongoRepository<User, String> {}