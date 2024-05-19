package kea.bowlingBackend.project.controller;

import kea.bowlingBackend.project.model.User;
import kea.bowlingBackend.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    public UserRepository userRepository;

    @GetMapping("/")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }



    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        return new ResponseEntity<>(userRepository.findById(id).orElse(null), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
    }
    


}
