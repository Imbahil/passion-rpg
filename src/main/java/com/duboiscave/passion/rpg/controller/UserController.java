package com.duboiscave.passion.rpg.controller;

import com.duboiscave.passion.rpg.domain.Repository.UserRepository;
import com.duboiscave.passion.rpg.domain.User;
import com.duboiscave.passion.rpg.dto.UserDto;
import com.duboiscave.passion.rpg.form.UserCreateForm;
import com.duboiscave.passion.rpg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import java.util.List;

import static com.duboiscave.passion.rpg.controller.UserController.Routes.ROOT;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    interface Routes {

        String ROOT = "/users";
    }

    private UserRepository userRepository;
    private UserService userService;

    @Autowired
    public UserController(final UserService userService, final UserRepository userRepository){
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping(ROOT)
    public List<User> getUsers() {
        return userRepository.findAll();
    }
    
    @PostMapping(ROOT)
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createProperty(@RequestBody @Valid final UserCreateForm userCreateForm){

        return userService.createUser(userCreateForm);
    }
}
