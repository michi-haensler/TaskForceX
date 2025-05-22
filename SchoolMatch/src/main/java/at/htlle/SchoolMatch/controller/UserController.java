package at.htlle.SchoolMatch.controller;

import at.htlle.SchoolMatch.model.UserDTO;
import at.htlle.SchoolMatch.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

    private final UserService svc;

    public UserController(UserService svc) {
        this.svc = svc;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> list() throws ExecutionException, InterruptedException {
        return ResponseEntity.ok(svc.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> get(@PathVariable String id)
            throws ExecutionException, InterruptedException {
        UserDTO u = svc.findById(id);
        return u != null ? ResponseEntity.ok(u) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO u)
            throws ExecutionException, InterruptedException {
        UserDTO saved = svc.save(u);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) throws ExecutionException, InterruptedException {
        svc.delete(id);
        return ResponseEntity.noContent().build();
    }
}
