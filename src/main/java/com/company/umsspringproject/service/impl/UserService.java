package com.company.umsspringproject.service.impl;

import com.company.umsspringproject.model.User;
import com.company.umsspringproject.model.constant.Constants;
import com.company.umsspringproject.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final Constants constants;
    public static  List<User> users = new ArrayList<>();
    @Override
    public ResponseEntity<String> addUser(User user) {
        users.add(user);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(constants.ADD_USER);
    }

    @Override
    public ResponseEntity<List<User>> showUsers() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(users);
    }

    @Override
    public ResponseEntity<User> findById(Long id) {
        User byUser = users.stream()
                .filter(user -> Objects.equals(user.getId(),id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found!"));
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(byUser);
    }

    @Override
    public ResponseEntity<User> findByName(String name, String role) {
        User byUser = users.stream()
                .filter(user -> Objects.equals(user.getName(),name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found!"));

        byUser.setRole(role);

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(byUser);
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {
        User byUser = users.stream()
                .filter(user -> Objects.equals(user.getId(),id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found!"));

        users.remove(byUser);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(constants.DELETE_USER);
    }
}
