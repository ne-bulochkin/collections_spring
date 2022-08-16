package ne.bulochkin.collections_spring.services;

import ne.bulochkin.collections_spring.model.Employee;
import ne.bulochkin.collections_spring.service.DepartmentService;
import ne.bulochkin.collections_spring.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    @Mock
    private EmployeeService employeeService;
    private DepartmentService departmentService;

    private final Map<String, Employee> employeeMap = new HashMap<>();

    @BeforeEach
    void setUp(){
        departmentService = new DepartmentService(employeeService);
        employeeMap.put("АндрейБулочкин",new Employee("Андрей","Булочкин","3",1200));
        employeeMap.put("СергейХмурый",new Employee("Сергей","Хмурый","3",9999));
        employeeMap.put("ИванДолгий",new Employee("Иван","Долгий","3",9999));
        employeeMap.put("ВасяБритый",new Employee("Вася","Бритый","2",1000));
        employeeMap.put("ОлегКартавый",new Employee("Олег","Картавый","2",9999999));
    }

    @Test
    void findEmployeeWithMaxSalaryByDepartment(){
        Mockito.when(employeeService.getEmployeeMap()).thenReturn(employeeMap);
        Assertions.assertEquals(new Employee("Олег","Картавый","2",9999999),departmentService.findEmployeeWithMaxSalaryByDepartment("2"));
    }

    @Test
    void findEmployeeWithMinSalaryByDepartment(){
        Mockito.when(employeeService.getEmployeeMap()).thenReturn(employeeMap);
        Assertions.assertEquals(new Employee("Вася","Бритый","2",1000),departmentService.findEmployeeWithMinSalaryByDepartment("2"));
    }

    @Test
    void findAllEmployeesByDepartment(){
        Mockito.when(employeeService.getEmployeeMap()).thenReturn(employeeMap);
        Assertions.assertEquals(2,departmentService.findAllEmployeesByDepartment("2").size());
        Assertions.assertEquals(3,departmentService.findAllEmployeesByDepartment("3").size());
    }

    @Test
    void groupAllByDepartment(){
        Mockito.when(employeeService.getEmployeeMap()).thenReturn(employeeMap);
        Assertions.assertEquals(2,departmentService.groupAllByDepartment().size());
    }

}
