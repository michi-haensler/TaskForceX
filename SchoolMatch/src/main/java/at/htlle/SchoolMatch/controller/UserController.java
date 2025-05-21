package at.htlle.SchoolMatch.controller;

import at.htlle.SchoolMatch.model.User;
import at.htlle.SchoolMatch.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    // GET /api/users
    @GetMapping
    public List<User> list() {
        return service.getAllUsers();
    }

    // GET /api/users/{id}
    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/users
    @PostMapping
    public ResponseEntity<User> create(@Valid @RequestBody User user) {
        if (service.findByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        User saved = service.createUser(user);
        return ResponseEntity.ok(saved);
    }

    // DELETE /api/users/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (service.getById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
