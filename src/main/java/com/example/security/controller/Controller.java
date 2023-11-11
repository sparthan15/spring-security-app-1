package com.example.security.controller;

import com.example.security.security.JwtUtil;
import com.example.security.service.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class Controller {

    private final AuthenticationManager authenticationManager;
    private final  JwtUtil jwtUtil;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        String email = authentication.getName();
        User user = new User(email, "");
        String token = jwtUtil.createToken(user);
        LoginResponse loginRes = new LoginResponse(email, token);

        return ResponseEntity.ok(loginRes);

    }
}
