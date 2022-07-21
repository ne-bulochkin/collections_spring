package ne.bulochkin.collections_spring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Неправильный формат переданных данных")
public class EmployeeWrongFormatException extends RuntimeException {
    public EmployeeWrongFormatException(String message) {
        super(message);
    }
}
