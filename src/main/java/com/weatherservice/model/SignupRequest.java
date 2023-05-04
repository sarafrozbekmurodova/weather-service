package com.weatherservice.model;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@Getter
@Setter
@NoArgsConstructor
public class SignupRequest {

    @NotNull(message = "first name is required")
    @Size(min = 3, max = 20)
    private String name;

    @Size(min = 3, max = 20)
    private String lastName;

    @NotNull(message = "username is required")
    @Size(min = 3, max = 20)
    private String username;


    @NotNull(message = "password is required")
    @Size(min = 6, max = 30)
    private String password;

    @NotNull(message = "email is required")
    @Email
    @Size( max = 50)
    private String email;

    private Set<String> role;


}
