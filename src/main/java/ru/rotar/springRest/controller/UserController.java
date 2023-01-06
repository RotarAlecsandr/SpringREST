package ru.rotar.springRest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.rotar.springRest.model.User;
import ru.rotar.springRest.model.UserAddress;
import ru.rotar.springRest.service.UserService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/index")
    @PreAuthorize("hasAnyRole ('USER', 'ADMIN')")
    public List<User> index() {
        return userService.findAll();
    }

    @PreAuthorize("hasAnyRole ('ADMIN')")
    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        return  userService.deleteUser(id);
    }

    @PostMapping(value = "new")
    @PreAuthorize("hasAnyRole ('ADMIN')")
    public void userCreate(@RequestBody User user) {
        userService.saveUser(user);
    }

    @PreAuthorize("hasAnyRole ('USER', 'ADMIN')")
    @GetMapping("/address/{id}")
    public UserAddress getAddress(@PathVariable int id)  {
        return userService.findOne(id).getUserAddress();
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAnyRole ('ADMIN')")
    public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable int id) {
        Optional<User> userOptional = Optional.ofNullable(userService.findOne(id));
        if (userOptional.isEmpty())
            return ResponseEntity.notFound().build();
        user.setId(id);
        userService.saveUser(user);
        return ResponseEntity.noContent().build();
    }
}