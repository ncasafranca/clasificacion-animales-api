package com.tesis.clasificacionanimalesapi.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.tesis.clasificacionanimalesapi.model.User;

public interface UserRepository extends CosmosRepository<User, String> {

}