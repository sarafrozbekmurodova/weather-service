package com.weatherservice.model;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@Getter
@Setter
@NoArgsConstructor
public class SignupRequest {

    @NonNull
    @Size(min = 3, max = 20)
    private String name;
    @NonNull
    @Size(min = 3, max = 20)
    private String lastName;

    @NonNull
    @Size(min = 3, max = 20)
    private String username;


    @NonNull
    @Size(min = 6, max = 30)
    private String password;

    @NonNull
    @Email
    @Size( max = 50)
    private String email;

    private Set<String> role;


}
