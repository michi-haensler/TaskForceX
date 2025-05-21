// src/main/java/at/htlle/controller/AuthController.java
package at.htlle.SchoolMatch.controller;

import at.htlle.SchoolMatch.security.JwtUtils;
import at.htlle.SchoolMatch.service.UserDetailsServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtUtils jwtUtils;

    public AuthController(AuthenticationManager authManager,
                          JwtUtils jwtUtils) {
        this.authManager = authManager;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginRequest req) {
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(auth);
        String jwt = jwtUtils.generateJwtToken(auth.getName());
        return ResponseEntity.ok(new JwtResponse(jwt));
    }
}
