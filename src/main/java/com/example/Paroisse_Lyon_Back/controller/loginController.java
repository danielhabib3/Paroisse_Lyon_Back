package com.example.Paroisse_Lyon_Back.controller;


import com.example.Paroisse_Lyon_Back.model.User;
import com.example.Paroisse_Lyon_Back.services.loginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class loginController {

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ) {
        Optional<User> user = loginService.verify(username, password);
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
    public String register(
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ) {
        System.out.println(username);
        System.out.println(password);

        return "Register";
    }

}

