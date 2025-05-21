// src/main/java/at/htlle/controller/AuthController.java
package at.htlle.SchoolMatch.controller;

import at.htlle.SchoolMatch.model.User;
import at.htlle.SchoolMatch.security.JwtUtils;
import at.htlle.SchoolMatch.service.UserDetailsServiceImpl;
import at.htlle.SchoolMatch.service.UserService;
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
    private final UserService userService;

    public AuthController(AuthenticationManager authManager,
                          JwtUtils jwtUtils,
                          UserService userService) {
        this.authManager = authManager;
        this.jwtUtils    = jwtUtils;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginRequest req) {
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(auth);
        String jwt = jwtUtils.generateJwtToken(auth.getName());
        return ResponseEntity.ok(new JwtResponse(jwt));
    }

    @PostMapping("/register")
    public ResponseEntity<JwtResponse> registerUser(@Valid @RequestBody SignupRequest req) {
        // Prüfen, ob E-Mail bereits existiert
        if (userService.findByEmail(req.getEmail()).isPresent()) {
            return ResponseEntity
                    .badRequest()
                    .body(new JwtResponse("Error: Email is already in use!"));
        }
        // Neues User-Objekt anlegen
        User user = new User(
                req.getEmail(),
                req.getPassword(),
                req.getName(),
                req.getKlasse(),
                req.getInteressen()
        );
        userService.createUser(user);

        // Direkt einloggen und Token generieren
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(auth);
        String jwt = jwtUtils.generateJwtToken(auth.getName());
        return ResponseEntity.ok(new JwtResponse(jwt));
    }
}
