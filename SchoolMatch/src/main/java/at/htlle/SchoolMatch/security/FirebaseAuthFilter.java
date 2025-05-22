package at.htlle.SchoolMatch.security;

import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

public class FirebaseAuthFilter extends OncePerRequestFilter {

    private final FirebaseAuthService authService;

    public FirebaseAuthFilter(FirebaseAuthService authService) {
        this.authService = authService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req,
                                    HttpServletResponse res,
                                    FilterChain chain)
            throws ServletException, IOException {
        String header = req.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            String idToken = header.substring(7);
            try {
                FirebaseToken decoded = authService.verifyIdToken(idToken);
                // Erzeuge Authentication mit Nutzer-E-Mail als Principal
                var auth = new UsernamePasswordAuthenticationToken(
                        decoded.getEmail(), null, List.of());
                SecurityContextHolder.getContext().setAuthentication(auth);
            } catch (FirebaseAuthException e) {
                // ungültiges Token → bleibt unauthenticated
            }
        }
        chain.doFilter(req, res);
    }
}
