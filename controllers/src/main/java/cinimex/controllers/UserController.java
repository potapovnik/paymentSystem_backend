package cinimex.controllers;

import cinimex.DTO.UserDto;
import cinimex.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/all")
    public List<UserDto> getAllUser(){
        return userService.getAllUser();
    }
    @PostMapping
    public UserDto createUser(@RequestBody UserDto newUser) throws Exception {
        return userService.createUser(newUser);
    }
    @PutMapping
    public UserDto updateUser(@RequestBody UserDto updateUser) throws Exception {
        return userService.updateUser(updateUser);
    }
    @DeleteMapping
    public boolean deleteUser(@RequestParam Long id) throws Exception {
        return userService.deleteUser(id);
    }
}
