package at.htlle.SchoolMatch.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotBlank
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String password;

    @NotBlank
    private String name;

    private String klasse;

    private String interessen;

    // --- Konstruktoren ---
    public User() { }

    public User(String email, String password, String name, String klasse, String interessen) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.klasse = klasse;
        this.interessen = interessen;
    }

    // --- Getter & Setter ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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
