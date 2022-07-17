package ne.bulochkin.collections_spring.controller;

import lombok.AllArgsConstructor;
import ne.bulochkin.collections_spring.model.Employee;
import ne.bulochkin.collections_spring.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping(path = "/add")
    public Employee add(@RequestParam(value = "firstName") String firstName,
                        @RequestParam(value = "lastName") String lastName,
                        @RequestParam(value = "department") String department,
                        @RequestParam(value = "salary") int salary) {
        return employeeService.add(firstName, lastName, department, salary);
    }

    @DeleteMapping(path = "/remove")
    public Employee remove(@RequestParam(value = "firstName") String firstName,
                           @RequestParam(value = "lastName") String lastName) {
        return employeeService.remove(firstName, lastName);
    }

    @GetMapping(path = "/find")
    public Employee find(@RequestParam(value = "firstName") String firstName,
                         @RequestParam(value = "lastName") String lastName) {
        return employeeService.find(firstName, lastName);
    }


}
