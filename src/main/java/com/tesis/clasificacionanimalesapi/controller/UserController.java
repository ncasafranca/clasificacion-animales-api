package com.tesis.clasificacionanimalesapi.controller;

import com.tesis.clasificacionanimalesapi.exception.UnKnownException;
import com.tesis.clasificacionanimalesapi.exception.UserNotFound;
import com.tesis.clasificacionanimalesapi.model.User;
import com.tesis.clasificacionanimalesapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    UserRepository userRepository;

    public String encodeEncryptUserPassword(String password)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordEncoded = passwordEncoder.encode(password);
        System.out.println("encoded password = " + passwordEncoded);
        return passwordEncoded;
    }

    // Create user
    @PostMapping
    public ResponseEntity<User> createUser
    (@RequestBody User user) {
        try {
                User newuser = new User(user.getFirstName(),
                        user.getLastName(), user.getRole(), user.getDocumentNumber(), user.getEmail(), encodeEncryptUserPassword(user.getPassword()),
                        encodeEncryptUserPassword(user.getRpassword()), user.getPhoneNumber());
                userRepository.save(newuser);
                return new ResponseEntity<>(newuser,
                        HttpStatus.CREATED);

        } catch (Exception e) {
            throw new UnKnownException(e.getMessage());
        }
    }

    // Update user
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser
    (@PathVariable("id") String id,
     @RequestBody User user) {

        Optional<User> userdata = userRepository
                .findById(id);
        if (userdata.isPresent()) {
            User _user = userdata.get();
            _user.setFirstName(user.getFirstName());
            _user.setLastName(user.getLastName());
            _user.setRole(user.getRole());
            _user.setDocumentNumber(user.getDocumentNumber());
            _user.setEmail(user.getEmail());
            _user.setPassword(encodeEncryptUserPassword(user.getPassword()));
            _user.setRpassword(encodeEncryptUserPassword(user.getRpassword()));
            _user.setPhoneNumber(user.getPhoneNumber());
            return new ResponseEntity<>
                    (userRepository.save(_user), HttpStatus.OK);
        } else {
            throw new UserNotFound("Invalid User Id");
        }
    }

    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserByID
    (@PathVariable("id") String id) {

        Optional<User> userdata = userRepository
                .findById(id);
        if (userdata.isPresent()) {
            return new ResponseEntity<>(userdata.get(),
                    HttpStatus.OK);
        } else {
            throw new UserNotFound("Invalid User Id");
        }

    }

    // Get all Users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {

        try {
            List<User> users = new ArrayList<User>();
            userRepository.findAll().forEach(users::add);
            return new ResponseEntity<>
                    (users, HttpStatus.OK);
        } catch (Exception e) {
            throw new UnKnownException(e.getMessage());
        }

    }

    // Delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser
    (@PathVariable("id") String id) {

        Optional<User> userdata = userRepository
                .findById(id);
        if (userdata.isPresent()) {
            userRepository.deleteById(id);
            return new ResponseEntity<>
                    (HttpStatus.NO_CONTENT);
        } else {
            throw new UserNotFound("Invalid User Id");
        }
    }

}