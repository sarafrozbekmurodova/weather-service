package com.weatherservice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserType {

    @JsonProperty("ADMIN")
    ADMIN("ADMIN"),
    @JsonProperty("SIMPLE")
    SIMPLE("SIMPLE"),
    @JsonProperty("ROOT")
    ROOT("ROOT");

    final String slug;

    UserType(String slug){
        this.slug = slug;
    }

    @JsonValue
    public String getSlug() {
        return slug;
    }
}
