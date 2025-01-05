package com.example.Paroisse_Lyon_Back.controller;


import com.example.Paroisse_Lyon_Back.model.User;
import com.example.Paroisse_Lyon_Back.services.accountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class accountController {

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ) {
        Optional<User> user = accountService.verify(username, password);
        Map<String, Object> response = new HashMap<>();
        // Login successful
        if (user.isPresent() && password.equals(user.get().getPassword())) {
            response.put("status", "success");
            response.put("message", "Login successful");
            response.put("user", Map.of("username", username, "roles", user.get().getRole()));
        }
        // Wrong password
        else if (user.isPresent() && !password.equals(user.get().getPassword())) {
            response.put("status", "success");
            response.put("message", "Wrong password");
            response.put("user", Map.of("username", username, "roles", user.get().getRole()));
        }
        // User doesn't exist
        else {
            response.put("status", "success");
            response.put("message", "User doesn't exist");
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("role") String role,
            @RequestParam("telephone") String telephone
    ) {
        Optional<User> user = accountService.verify(username, password);
        Map<String, Object> response = new HashMap<>();
        // The username doesn't exist
        if(user.isEmpty()) {
            accountService.register(username, password, role, telephone);
            response.put("status", "success");
            response.put("message", "User registered successfully");
        }
        // The username already exists
        else {
            response.put("status", "success");
            response.put("message", "The username already exists");
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/roles")
    public ResponseEntity<?> getRoles() {
        Map<String, Object> response = new HashMap<>();
        response.put("roles", accountService.getRoles());
        return ResponseEntity.ok(response);
    }

}

