package eight.bit.chatBot.controller;


import eight.bit.chatBot.entity.Department;
import eight.bit.chatBot.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
@AllArgsConstructor
public class DepartmentController {
 private final DepartmentService departmentService ;

    @PostMapping
    public ResponseEntity<Department> createDept(@RequestBody Department dept) {
        return ResponseEntity.ok(departmentService.saveDepartment(dept));
    }

    @GetMapping
    public ResponseEntity<Department> getDepartment(@PathVariable Long agencyId) {
        return ResponseEntity.ok(departmentService.getDeptsByAgency(agencyId));
    }
}
