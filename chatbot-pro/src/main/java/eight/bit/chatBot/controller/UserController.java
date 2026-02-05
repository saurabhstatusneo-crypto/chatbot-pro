package eight.bit.chatBot.controller;

import eight.bit.chatBot.entity.User;
import eight.bit.chatBot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/colleagues")
    public ResponseEntity<List<User>> getColleagues(Principal principal) {
        // Find the logged-in user
        User currentUser = userRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Fetch ONLY users from the same department
        List<User> colleagues = userRepository.findByDepartment(currentUser.getDepartment())
                .stream()
                .filter(user -> !user.getUsername().equals(currentUser.getUsername()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(colleagues);
    }
}
