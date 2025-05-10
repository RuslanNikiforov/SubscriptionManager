package ruslan.SubscriptionManager.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ruslan.SubscriptionManager.dto.UserResponse;
import ruslan.SubscriptionManager.entities.User;
import ruslan.SubscriptionManager.services.UserService;
import ruslan.SubscriptionManager.services.UserServiceImpl;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    public ResponseEntity<UserResponse> save(@RequestBody User user) {
        User savedUser = userService.save(user);
        return ResponseEntity.ok(UserServiceImpl.toDTO(savedUser));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable Long id) {
        User user = userService.getById(id);
        return ResponseEntity.ok(UserServiceImpl.toDTO(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(@RequestBody User user) {
        User updatedUser = userService.save(user);
        return ResponseEntity.ok(UserServiceImpl.toDTO(updatedUser));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

}
