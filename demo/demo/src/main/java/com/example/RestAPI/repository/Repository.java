package com.example.RestAPI.repository;

import com.example.RestAPI.model.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

@org.springframework.stereotype.Repository
public interface Repository extends MongoRepository<UserEntity, String> {
}
