package com.youcode.security.Service;

import com.youcode.security.dto.Request.AuthenticationRequest;
import com.youcode.security.dto.Request.RegisterRequest;
import com.youcode.security.dto.Response.AuthenticationResponse;
import org.springframework.stereotype.Component;

@Component
public interface AuthenticationService {

    AuthenticationResponse register(RegisterRequest user);

    AuthenticationResponse authenticate(AuthenticationRequest user);
}