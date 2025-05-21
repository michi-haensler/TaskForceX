// src/main/java/at/htlle/service/UserService.java
package at.htlle.SchoolMatch.service;

import at.htlle.SchoolMatch.model.User;
import at.htlle.SchoolMatch.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repo;
    private final BCryptPasswordEncoder encoder;

    public UserService(UserRepository repo) {
        this.repo = repo;
        // Encoder hier initialisieren
        this.encoder = new BCryptPasswordEncoder();
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public Optional<User> getById(Long id) {
        return repo.findById(id);
    }

    public User createUser(User user) {
        // Passwort hashen
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

    public void deleteUser(Long id) {
        repo.deleteById(id);
    }

    public Optional<User> findByEmail(String email) {
        return repo.findByEmail(email);
    }
}
