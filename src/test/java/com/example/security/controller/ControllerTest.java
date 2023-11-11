package com.example.security.controller;


import com.example.security.security.JwtUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {

    @InjectMocks
    private Controller controller;
    @Mock
    private JwtUtil jwtUtil;
    @Mock
    private AuthenticationManager authenticationManager;

    @Test
    public void canCreate() {
        ResponseEntity<LoginResponse> result = controller.login(LoginRequest.create("carlosgamboa15@gmail.com", "123456"));
        Assertions.assertThat(result).isNotNull();
    }
}
