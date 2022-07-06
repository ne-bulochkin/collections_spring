package ne.bulochkin.collections_spring.exceptions;

public class EmployeeStorageIsFullException extends Exception {
    public EmployeeStorageIsFullException(String message) {
        super(message);
    }
}
