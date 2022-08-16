package ne.bulochkin.collections_spring.controller;

import lombok.AllArgsConstructor;
import ne.bulochkin.collections_spring.model.Department;
import ne.bulochkin.collections_spring.model.Employee;
import ne.bulochkin.collections_spring.service.DepartmentService;
import ne.bulochkin.collections_spring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/departments")
public class DepartmentController {
//    @Autowired
//    private final EmployeeService employeeService;
//
//    @Autowired
//    private final DepartmentService departmentService;
//
//    @GetMapping(path = "/max-salary")
//    public Employee getMaxSalary(@RequestParam(value = "departmentId") String departmentId) {
//        return employeeService.findEmployeeWithMaxSalaryByDepartment(departmentId);
//    }
//
//    @GetMapping(path = "/min-salary")
//    public Employee getMinSalary(@RequestParam(value = "departmentId") String departmentId) {
//        return employeeService.findEmployeeWithMinSalaryByDepartment(departmentId);
//    }
//
//    @GetMapping(path = "/all", params = "departmentId")
//    public List<Employee> getAllByDepartment(@RequestParam(value = "departmentId") String departmentId) {
//        return employeeService.findAllEmployeesByDepartment(departmentId);
//    }
//
//    @GetMapping(path = "/all")
//    public List<Department> getAll() {
//        return departmentService.groupAllByDepartment();
//    }
}
