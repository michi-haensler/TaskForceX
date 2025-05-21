package at.htlle.SchoolMatch.config;

import at.htlle.SchoolMatch.security.AuthTokenFilter;
import at.htlle.SchoolMatch.security.JwtUtils;
import at.htlle.SchoolMatch.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JwtUtils jwtUtils;
    private final UserDetailsServiceImpl userDetailsService;

    public SecurityConfig(JwtUtils jwtUtils, UserDetailsServiceImpl uds) {
        this.jwtUtils = jwtUtils;
        this.userDetailsService = uds;
    }

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter(jwtUtils, userDetailsService);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // CSRF deaktivieren
                .csrf(csrf -> csrf.disable())

                // Stateless Session Management mit Lambda-DSL (nicht mehr deprecated)
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )

                // Authorisierungen
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/**").permitAll()
                        .anyRequest().authenticated()
                );

        // Unser JWT-Filter vor dem UsernamePasswordAuthenticationFilter einfügen
        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
}
