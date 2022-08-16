package ne.bulochkin.collections_spring.service;

import ne.bulochkin.collections_spring.model.Department;
import ne.bulochkin.collections_spring.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee findEmployeeWithMaxSalaryByDepartment(String department) {
        return employeeService.getEmployeeMap().values().stream()
                .filter(e -> e.getDepartment().equals(department))
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow();
    }

    public Employee findEmployeeWithMinSalaryByDepartment(String department) {
        return employeeService.getEmployeeMap().values().stream()
                .filter(e -> e.getDepartment().equals(department))
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow();
    }

    public List<Employee> findAllEmployeesByDepartment(String department) {
        return employeeService.getEmployeeMap().values().stream()
                .filter(e -> e.getDepartment().equals(department))
                .collect(Collectors.toList());
    }


    public List<Department> groupAllByDepartment() {
        return employeeService.getEmployeeMap().values()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .entrySet()
                .stream()
                .map(e -> {
                    Department dep = new Department();
                    dep.setDepartment(e.getKey());
                    dep.setEmployees(e.getValue());
                    return dep;
                })
                .collect(Collectors.toList());
    }
}
