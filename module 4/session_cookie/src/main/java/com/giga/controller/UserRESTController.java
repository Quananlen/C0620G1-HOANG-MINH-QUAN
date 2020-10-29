package com.giga.controller;

import com.giga.entity.User;
import com.giga.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRESTController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/list")
    public ResponseEntity<List<User>> listAll() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Void> save(User user) {
        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id) {
        return new ResponseEntity<>(userRepository.findById(id).orElse(null), HttpStatus.OK);
    }
}
