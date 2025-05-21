// src/main/java/at/htlle/controller/SignupRequest.java
package at.htlle.SchoolMatch.controller;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SignupRequest {
    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 6, message = "Passwort muss mindestens 6 Zeichen lang sein")
    private String password;

    @NotBlank
    private String name;

    private String klasse;
    private String interessen;

    // Getter und Setter
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getKlasse() { return klasse; }
    public void setKlasse(String klasse) { this.klasse = klasse; }

    public String getInteressen() { return interessen; }
    public void setInteressen(String interessen) { this.interessen = interessen; }
}
