package com.weatherservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
public class JwtResponse {

    @NotNull
    private String token;

    private String type = "Bearer";

    @NotNull
    private String id;

    @NotNull
    private String name;

    @NotNull
    private String username;
    @NotNull
    private String lastName;

    @NotNull
    private String email;

    @NotNull
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

    public JwtResponse(String jwt, String id, String name, String lastName, String username, String email, List<String> roles) {
    }
}
