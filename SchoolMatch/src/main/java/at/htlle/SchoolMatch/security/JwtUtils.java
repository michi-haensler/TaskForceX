// src/main/java/at/htlle/security/JwtUtils.java
package at.htlle.SchoolMatch.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtils {

    // Direkt einen sicheren 512-Bit-Schlüssel erzeugen
    private final SecretKey signingKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    private final long jwtExpirationMs = 3600000; // 1 Stunde

    public String generateJwtToken(String username) {
        Date now = new Date();
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + jwtExpirationMs))
                .signWith(signingKey)
                .compact();
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(signingKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(signingKey)
                    .build()
                    .parseClaimsJws(authToken);
            return true;
        } catch (JwtException e) {
            // Token ungültig
        }
        return false;
    }
}
