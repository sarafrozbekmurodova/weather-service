package com.weatherservice.model;

import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@Getter
@Setter
@NoArgsConstructor
public class LoginRequest {


    @NotNull(message = "username is required")
    private String username;

    @NotNull(message = "password is required")
    private String password;
}
