package ne.bulochkin.collections_spring.model;

import java.util.List;

public class Department {
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    private String department;
    private List<Employee> employees;
}
