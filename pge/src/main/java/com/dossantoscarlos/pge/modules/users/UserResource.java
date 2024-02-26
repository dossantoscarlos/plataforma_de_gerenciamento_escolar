package com.dossantoscarlos.pge.modules.users;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.dossantoscarlos.pge.core.config.Error.HandlerResponseExceptionApiController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserResource extends HandlerResponseExceptionApiController {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        return this.userService.save(user);
    }
}