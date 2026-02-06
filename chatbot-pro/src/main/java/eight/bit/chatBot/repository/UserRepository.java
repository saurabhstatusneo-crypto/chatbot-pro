package eight.bit.chatBot.repository;

import eight.bit.chatBot.entity.DepartmentList;
import eight.bit.chatBot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Used to list colleagues within the same department
    List<User> findByDepartment(DepartmentList department);
    Optional<User> findByUsername(String username);
}
