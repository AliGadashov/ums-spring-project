package com.company.umsspringproject.controller;

import com.company.umsspringproject.model.User;
import com.company.umsspringproject.service.impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;


    @PostMapping("/registration")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getUsers() {
        return userService.showUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/{name}")
    public ResponseEntity<User> findByName(@RequestParam(required = false) String name, @RequestHeader("role") String role) {
        return userService.findByName(name, role);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        return userService.deleteById(id);
    }

}
