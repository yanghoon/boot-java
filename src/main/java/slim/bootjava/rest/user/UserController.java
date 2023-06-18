package slim.bootjava.rest.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import slim.bootjava.domain.user.entity.User;
import slim.bootjava.domain.user.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {
    
    private final UserService userService;

    @GetMapping("api/users")
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @PostMapping("api/users")
    public ResponseEntity<?> addComment(@RequestBody User user) {
        User registerd = userService.register(user);
        return ResponseEntity.ok(registerd);
    }

}
