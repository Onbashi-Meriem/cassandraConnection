package com.example.demo.api;

import com.example.demo.UserRepository;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository repository;

    @PostConstruct
    public void saveUser(){
        List<User> users=new ArrayList<>();
        users.add(new User(1, "meryem","hannover",38));
        users.add(new User(2, "caner","hannover",39));
        users.add(new User(3, "mumin","hannover",34));
        repository.saveAll(users);
    }

    @GetMapping("/getAllUsers")
    public List<User> getUsers(){
        return repository.findAll();
    }
}
