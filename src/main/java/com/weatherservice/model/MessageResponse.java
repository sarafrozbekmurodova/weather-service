package com.weatherservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class MessageResponse {

    @NotNull
    private String message;

    public MessageResponse(String s) {
        this.message=s;
    }
}
