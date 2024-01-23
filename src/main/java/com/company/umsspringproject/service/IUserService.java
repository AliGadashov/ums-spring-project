package com.company.umsspringproject.service;

import com.company.umsspringproject.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserService {
    ResponseEntity<String> addUser(User user);
    ResponseEntity<List<User>> showUsers();
    ResponseEntity<User> findById(Long id);
    ResponseEntity<User> findByName(String name, String role);
    ResponseEntity<String> deleteById(Long id);
}
