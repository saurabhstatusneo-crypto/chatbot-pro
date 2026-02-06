package eight.bit.chatBot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long agencyId;
    private Long departmentId;

    @Column(unique = true)
    private String username;

    private String password; // Encoded
    @Enumerated(EnumType.STRING)
    private DepartmentList department; // JAVA or MERN

}


