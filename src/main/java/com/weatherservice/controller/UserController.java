package com.weatherservice.controller;

import com.weatherservice.model.*;
import com.weatherservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/users")
@RequiredArgsConstructor
public class UserController {
    UserService userService;
    @PostMapping("/register")
    public ResponseEntity<MessageResponse> registerUser(@RequestBody @Valid SignupRequest model){
        return ResponseEntity.ok(userService.signUp(model).getBody());
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody @Valid LoginRequest model,
                                             BindingResult result){
        return ResponseEntity.ok(userService.loginUser(model,result));
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<UserDetailModel> getUserById(@PathVariable("id")String id){
        return ResponseEntity.ok(userService.getUserDetail(id));
    }

}
