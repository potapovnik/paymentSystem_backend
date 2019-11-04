package cinimex.controllers;

import cinimex.DTO.TransferDto;
import cinimex.DTO.UserDto;
import cinimex.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;


    @GetMapping("/all")
    public List<UserDto> getAllUser() {
        return userService.getAllUser();
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto newUser) throws Exception {
        return userService.createUser(newUser);
    }

    @PostMapping("/registerNewUser")
    public UserDto registerNewUser(@RequestBody UserDto newUser) throws Exception {
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

    @RequestMapping("/current")
    public Principal user(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization")
                .substring("Basic".length()).trim();
        return () -> new String(Base64.getDecoder()
                .decode(authToken)).split(":")[0];
    }
    @GetMapping("/byLogin")
    public UserDto getUserByLogin(@RequestParam String login){
        return userService.findUserByLogin(login);
    }
}
