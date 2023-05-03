package com.weatherservice.exceptions;

public class NotFoundRequestException extends CustomGeneralException{

    public NotFoundRequestException(String message, String code) {
        super(message, code);
    }

    public NotFoundRequestException() {
        super("Resource not found", "0000");
    }
}
