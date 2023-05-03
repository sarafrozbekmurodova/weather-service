package com.weatherservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class JwtResponse {

    @NonNull
    private String token;

    private String type = "Bearer";

    @NonNull
    private String id;

    @NonNull
    private String name;

    @NonNull
    private String username;
    @NonNull
    private String lastName;

    @NonNull
    private String email;

    @NonNull
    private List<String> roles;

    public JwtResponse( String token, String type,
                        String id,  String name,String lastName,
                        String username,  String email,
                        List<String> roles) {
        this.token = token;
        this.type = type;
        this.id = id;
        this.name = name;
        this.lastName=lastName;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }


}
