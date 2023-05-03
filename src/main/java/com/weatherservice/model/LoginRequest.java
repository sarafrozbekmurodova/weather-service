package com.weatherservice.model;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
public class LoginRequest {


    @NonNull
    private String username;

    @NonNull
    private String password;
}
