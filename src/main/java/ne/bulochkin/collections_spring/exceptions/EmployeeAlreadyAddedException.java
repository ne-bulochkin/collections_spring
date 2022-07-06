package ne.bulochkin.collections_spring.exceptions;

public class EmployeeAlreadyAddedException extends Exception {
    public EmployeeAlreadyAddedException(String message) {
        super(message);
    }
}
