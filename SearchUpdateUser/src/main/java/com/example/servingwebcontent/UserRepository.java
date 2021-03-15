package com.example.servingwebcontent;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    public User findByFirstname(String firstname);
}