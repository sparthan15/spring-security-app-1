package com.example.security.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
@Setter
public class ErrorResponse {
    private final HttpStatus httpStatus;
    private final String message;

}
