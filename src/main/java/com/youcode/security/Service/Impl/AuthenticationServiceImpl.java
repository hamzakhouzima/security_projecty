package com.youcode.security.Service.Impl;


import com.youcode.security.GlobalStates.Global;
import com.youcode.security.Model.Role;
import com.youcode.security.Model.Roles;
import com.youcode.security.Model.User;
import com.youcode.security.Repository.RoleRepository;
import com.youcode.security.Repository.UserRepository;
import com.youcode.security.Security.JwtService;
import com.youcode.security.Service.AuthenticationService;
import com.youcode.security.dto.Request.AuthenticationRequest;
import com.youcode.security.dto.Request.RegisterRequest;
import com.youcode.security.dto.Response.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


//    @Autowired
    private  final RoleRepository roleRepository;

    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        // Assuming 'USER' is the default role for a new user
        Roles defaultRole = Roles.USER;

//        Roles role = roleRepository.findRoleByRoleName(defaultRole.name());

        var user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(Collections.singleton(defaultRole))
                .build();

        userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);
        System.out.println(jwtToken +"  " + request.getPassword() +"  "+ request.getUsername());

        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        try {
            logger.info("Attempting to authenticate user: {}", request.getUsername());

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );

            logger.info("User {} authenticated successfully", request.getUsername());

            User user = userRepository.findUserByUsername(request.getUsername())
                    .orElseThrow(() -> {
                        logger.error("User not found: {}", request.getUsername());
                        return new UsernameNotFoundException("User not found");
                    });

            String jwtToken = jwtService.generateToken(user);

            logger.info("JWT token generated successfully for user: {}", request.getUsername());

            return AuthenticationResponse.builder().token(jwtToken).build();
        } catch (AuthenticationException e) {
            logger.error("Authentication failed for user: {}", request.getUsername(), e);
            throw new BadCredentialsException("Invalid username or password");
        }
    }



}