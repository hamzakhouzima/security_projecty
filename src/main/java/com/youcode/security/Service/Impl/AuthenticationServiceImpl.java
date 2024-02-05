package com.youcode.security.Service.Impl;


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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

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
                .username(request.getUserName())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(defaultRole)
                .build();

        userRepository.save(user);

        var jwtToken = jwtService.generateToken((UserDetails) user);
        System.out.println(jwtToken);

        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        var user = userRepository.findUserByUsername(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken((UserDetails) user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}