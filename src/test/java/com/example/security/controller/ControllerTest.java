package com.example.security.controller;


import com.example.security.config.JwtUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {

    @InjectMocks
    private Controller controller;
    @Mock
    private JwtUtil jwtUtil;
    @Mock
    private AuthenticationManager authenticationManager;
    @Mock
    private Authentication authenticated;
    @Test
    public void givenEmailAndPasswordAreCorrectThenLoginSuccess() {
        Mockito.when(authenticated.getName()).thenReturn("carlos");
        Mockito.when(authenticationManager.authenticate(Mockito.any())).thenReturn(authenticated);
        ResponseEntity<LoginResponse> result = controller.login(LoginRequest.create("carlosgamboa15@gmail.com", "123456"));
        assertThat(result).isNotNull();
        assertThat(result.getBody()).isNotNull();
    }

    @Test
    public void successLoginReturnUserNameAndEmail() {
        Mockito.when(authenticated.getName()).thenReturn("carlos");
        Mockito.when(authenticationManager.authenticate(Mockito.any())).thenReturn(authenticated);
        ResponseEntity<LoginResponse> result = controller.login(LoginRequest.create("carlosgamboa15@gmail.com", "123456"));
        assertThat(result).isNotNull();
        assertThat(result.getBody()).isNotNull();
        assertThat(result.getBody().getEmail()).isEqualTo("carlos");
    }
}
