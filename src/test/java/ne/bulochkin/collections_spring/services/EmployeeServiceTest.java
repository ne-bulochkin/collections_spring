package ne.bulochkin.collections_spring.services;

import ne.bulochkin.collections_spring.exceptions.EmployeeAlreadyAddedException;
import ne.bulochkin.collections_spring.exceptions.EmployeeNotFoundException;
import ne.bulochkin.collections_spring.exceptions.EmployeeStorageIsFullException;
import ne.bulochkin.collections_spring.exceptions.EmployeeWrongFormatException;
import ne.bulochkin.collections_spring.model.Employee;
import ne.bulochkin.collections_spring.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class EmployeeServiceTest {
    private final EmployeeService employeeService = new EmployeeService();

    @BeforeEach
    void setUp(){
        employeeService.add("Сергей","Орлов","1",12000);
        employeeService.add("Олег","Орлов","1",12000);
        employeeService.add("Петя","Мерков","1",12000);
        employeeService.add("Иван","Супов","3",9000);
        employeeService.add("Женя","Бегов","3",99000);
    }
    @Test
    void addNewEmployee(){
        Assertions.assertEquals(new Employee("Сергей", "Орлов", "1", 12000),employeeService.find("Сергей","Орлов"));
    }

    @Test
    void addExistedEmployee(){
        Assertions.assertThrows(EmployeeAlreadyAddedException.class,() -> employeeService.add("Олег","Орлов","1",12000));
    }

    @Test
    void addWrongName(){
        Assertions.assertThrows(EmployeeWrongFormatException.class,() -> employeeService.add("О2лег","Ор-лов","1",12000));
    }

    @Test
    void addMoreThenLimitEmployee(){
        Random r = new Random();
        for(int i = 0; i<5;i++){
            employeeService.add("Олег"+(char)(r.nextInt(26) + 'a'),"Семенов"+(char)(r.nextInt(26) + 'a'),"1",12000);
        }
        Assertions.assertThrows(EmployeeStorageIsFullException.class,() -> employeeService.add("Иван","Орлов","1",12000));
    }

    @Test
    void findEmployee(){
        Assertions.assertDoesNotThrow(() -> employeeService.find("Иван","Супов"));
    }

    @Test
    void removeEmployee(){
        employeeService.remove("Иван","Супов");
        Assertions.assertThrows(EmployeeNotFoundException.class,() -> employeeService.find("Иван","Супов"));
    }
}
