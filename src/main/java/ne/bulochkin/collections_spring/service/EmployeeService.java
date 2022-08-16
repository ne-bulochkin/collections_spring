package ne.bulochkin.collections_spring.service;

import ne.bulochkin.collections_spring.exceptions.EmployeeAlreadyAddedException;
import ne.bulochkin.collections_spring.exceptions.EmployeeNotFoundException;
import ne.bulochkin.collections_spring.exceptions.EmployeeStorageIsFullException;
import ne.bulochkin.collections_spring.exceptions.EmployeeWrongFormatException;
import ne.bulochkin.collections_spring.model.Department;
import ne.bulochkin.collections_spring.model.Employee;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    public Map<String, Employee> getEmployeeMap() {
        return employeeMap;
    }

    private final Map<String, Employee> employeeMap = new HashMap<>();

    public Employee add(String firstName, String lastName, String department, int salary) {
        int EMPLOYEE_LIMIT = 10;
        // check the format
        if(!StringUtils.isAlpha(lastName+firstName)){
            throw new EmployeeWrongFormatException("В фамилии и имени неправильные символы!");
        }
        // change first letter
        lastName = StringUtils.capitalize(lastName);
        firstName = StringUtils.capitalize(firstName);

        //

        if (employeeMap.size() >= EMPLOYEE_LIMIT) {
            throw new EmployeeStorageIsFullException("Массив сотрудников переполнен! Добавить не получилось!");
        } else if (!employeeMap.containsKey(firstName + lastName)) {
            employeeMap.put(firstName + lastName, new Employee(firstName, lastName, department, salary));
            return new Employee(firstName, lastName, department, salary);
        } else {
            throw new EmployeeAlreadyAddedException("Данный сотрудник уже был добавлен в массив ранее!");
        }
    }

    public Employee remove(String firstName, String lastName) {

        if (employeeMap.containsKey(firstName + lastName)) {
            Employee removeEmployee = employeeMap.get(firstName + lastName);
            employeeMap.remove(firstName + lastName);
            return removeEmployee;
        } else {
            throw new EmployeeNotFoundException("Данный сотрудник не найден, невозможно удалить!");
        }
    }

    public Employee find(String firstName, String lastName) {
        if (employeeMap.containsKey(firstName + lastName)) {
            Employee findEmployee = employeeMap.get(firstName + lastName);
            return findEmployee;
        }
        throw new EmployeeNotFoundException("Данный сотрудник не найден!");
    }


}