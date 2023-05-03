package com.weatherservice.service;

import com.weatherservice.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface UserService {
    JwtResponse loginUser(LoginRequest loginRequest, BindingResult result);

    ResponseEntity<MessageResponse> signUp(SignupRequest signupRequest);

    UserDetailModel getUserDetail(String  userId);
}
