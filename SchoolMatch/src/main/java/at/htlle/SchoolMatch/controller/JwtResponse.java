// src/main/java/at/htlle/controller/JwtResponse.java
package at.htlle.SchoolMatch.controller;

public class JwtResponse {
    private String token;

    public JwtResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
