package ne.bulochkin.collections_spring.service;

import ne.bulochkin.collections_spring.exceptions.EmployeeAlreadyAddedException;
import ne.bulochkin.collections_spring.exceptions.EmployeeNotFoundException;
import ne.bulochkin.collections_spring.exceptions.EmployeeStorageIsFullException;
import ne.bulochkin.collections_spring.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    private Map<String,Employee> employeeMap = new HashMap<>();

    public Employee add(String firstName, String lastName) {
        int EMPLOYEE_LIMIT = 10;
        if(employeeMap.size()>= EMPLOYEE_LIMIT){
            throw new EmployeeStorageIsFullException("Массив сотрудников переполнен! Добавить не получилось!");
        } else if (!employeeMap.containsKey(firstName+lastName)){
            employeeMap.put(firstName+lastName,new Employee(firstName, lastName));
            return new Employee(firstName, lastName);
        } else {
            throw new EmployeeAlreadyAddedException("Данный сотрудник уже был добавлен в массив ранее!");
        }
    }

    public Employee remove(String firstName, String lastName) {
        Employee removeEmployee = new Employee(firstName, lastName);
        if(employeeMap.containsKey(firstName+lastName)){
            employeeMap.remove(firstName+lastName);
            return removeEmployee;
        } else {
            throw new EmployeeNotFoundException("Данный сотрудник не найден, невозможно удалить!");
        }
    }

    public Employee find(String firstName, String lastName) {
        Employee findEmployee = new Employee(firstName, lastName);
        if(employeeMap.containsKey(findEmployee+lastName)){
            return findEmployee;
        }
        throw new EmployeeNotFoundException("Данный сотрудник не найден!");
    }
}