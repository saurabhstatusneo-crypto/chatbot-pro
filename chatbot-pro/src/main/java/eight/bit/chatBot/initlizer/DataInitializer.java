package eight.bit.chatBot.initlizer;

import eight.bit.chatBot.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired private PasswordEncoder passwordEncoder;

    @Override
    @Transactional // Ensure this runs in a single transaction
    public void run(String... args) {
        // Clear anything existing to prevent "StaleObjectState"
        userRepository.deleteAllInBatch();

        if (userRepository.count() == 0) {
//            List<User> initialUsers = List.of(
//                    new User( "java_dev1", passwordEncoder.encode("123"), Department.JAVA),
//                    new User("java_dev2", passwordEncoder.encode("123"), Department.JAVA),
//                    new User("hoshiyar", passwordEncoder.encode("123"), Department.JAVA),
//                    new User("mern_dev1", passwordEncoder.encode("123"), Department.MERN),
//                    new User("mern_dev2", passwordEncoder.encode("123"), Department.MERN)
//            );
//            userRepository.saveAll(initialUsers);
            System.out.println("Users initialized successfully!");
        }
    }
}
