package com.youcode.security.Controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequiredArgsConstructor
public class OperationsController {

    private static final Logger logger = LoggerFactory.getLogger(OperationsController.class);

    @GetMapping("/User")
    @PreAuthorize("hasRole('USER')") // Secure route accessible only to users with USER role
    public ResponseEntity<String> userRoute() {
        logger.info("Accessing /api/User endpoint...");
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            logger.info("Authenticated user: {}", username);
        } else {
            logger.warn("No authenticated user found.");
        }

        return ResponseEntity.ok("User");
    }

    @GetMapping("/Admin")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> AdminRoute() {
        logger.info("Accessing /api/Admin endpoint...");
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            logger.info("Authenticated Admin: {}", username);
        } else {
            logger.warn("No authenticated Admin found.");
        }

        return ResponseEntity.ok("Admin");
    }
}
