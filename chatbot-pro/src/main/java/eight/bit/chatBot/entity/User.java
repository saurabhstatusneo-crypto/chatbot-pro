package eight.bit.chatBot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
//    @JsonIgnore
    private String password; // Encoded

    @Enumerated(EnumType.STRING)
    private Department department; // JAVA or MERN

    public User(String username, String password, Department department) {
        this.username = username;
        this.password = password;
        this.department = department;
    }
}


