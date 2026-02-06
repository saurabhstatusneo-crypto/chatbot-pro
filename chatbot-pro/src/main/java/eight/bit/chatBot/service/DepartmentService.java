package eight.bit.chatBot.service;

import eight.bit.chatBot.entity.Department;
import eight.bit.chatBot.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository ;

    public Department saveDepartment(Department dept) {
        return departmentRepository.save(dept);
    }
    public Department getDeptsByAgency(Long agencyId) {
        return departmentRepository.findByAgencyId(agencyId).orElseThrow(()-> new UsernameNotFoundException("error.msg.user.not.found.exception"));
    }
}
