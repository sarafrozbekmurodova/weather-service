package com.weatherservice.model;

import com.weatherservice.entity.UserType;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@NoArgsConstructor
public class UserDetailModel {
    private String id;
    private String firstName;
    private String lastname;
    private String email;
    private LocalDateTime createdAt;
    private String userName;
    private UserType roles;
}
