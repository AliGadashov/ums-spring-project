package com.company.umsspringproject.controller;

import com.company.umsspringproject.model.User;
import com.company.umsspringproject.service.impl.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Slf4j
public class UserController {

    private final UserService userService;


    @PostMapping("/registration")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        log.info("request -> /registration - {}", user);
        log.info("response -> /registration - none");

        return userService.addUser(user);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getUsers() {
        log.info("request -> /all - none");
        ResponseEntity<List<User>> listResponseEntity = userService.showUsers();
        log.info("responce -> /all - list - {}", listResponseEntity);

        return listResponseEntity;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        log.info("request -> - /{}",id);
        ResponseEntity<User> userResponseEntity = userService.findById(id);
        log.info("responce -> /{} - model -{}",id,userResponseEntity);

        return userResponseEntity;

    }

    @GetMapping()
    public ResponseEntity<User> findByName(@RequestParam(required = false) String name, @RequestHeader("role") String role) {
       log.info("request -> / - name - {}, header - {}",name, role);
        ResponseEntity<User> byName = userService.findByName(name, role);
        log.info("responce -> / - name - {} - header - {} - model - {}",name,role,byName);

        return byName;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        log.info("request -> /{}",id);
        log.info("responce -> none");

        return userService.deleteById(id);
    }

}
