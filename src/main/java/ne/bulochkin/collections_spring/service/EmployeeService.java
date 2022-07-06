package ne.bulochkin.collections_spring.service;

import ne.bulochkin.collections_spring.exceptions.EmployeeAlreadyAddedException;
import ne.bulochkin.collections_spring.exceptions.EmployeeNotFoundException;
import ne.bulochkin.collections_spring.exceptions.EmployeeStorageIsFullException;
import ne.bulochkin.collections_spring.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {
    private List<Employee> employees = Arrays.asList(new Employee[10]);


    public Employee add(String firstName, String lastName) {
        for (int i = 0; i < employees.size(); i++) {
            Employee addEmployee = new Employee(firstName, lastName);
            if (employees.get(i) == null) {
                employees.set(i, addEmployee);
                return addEmployee;
            }
            if (employees.get(i).equals(addEmployee)) {
                throw new EmployeeAlreadyAddedException("Данный сотрудник уже был добавлен в массив ранее!");
            }
            if (i == employees.size() - 1) {
                throw new EmployeeStorageIsFullException("Массив сотрудников переполнен! Добавить не получилось!");
            }
        }
        return null;
    }

    public Employee remove(String firstName, String lastName) {
        System.out.println(employees);
        Employee removeEmployee = new Employee(firstName, lastName);
        for (int i = 0; i < employees.size(); i++) {
            if (!employees.contains(removeEmployee)) {
                throw new EmployeeNotFoundException("Данный сотрудник не найден, невозможно удалить!");
            }
            if (employees.get(i).equals(removeEmployee)) {
                employees.set(i, null);
                return removeEmployee;
            }
        }
        return null;
    }

    public Employee find(String firstName, String lastName) {
        Employee findEmployee = new Employee(firstName, lastName);
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.equals(findEmployee))
                    return findEmployee;
            }
        }
        throw new EmployeeNotFoundException("Данный сотрудник не найден!");
    }
}