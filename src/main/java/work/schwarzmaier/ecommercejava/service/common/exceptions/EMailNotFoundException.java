package work.schwarzmaier.ecommercejava.service.common.exceptions;

import org.springframework.http.HttpStatus;

public class EMailNotFoundException extends Exception {

    private static final String errorMsg = "Can not found E-Mail. E-Mail: %s";

    private static final HttpStatus httpStatus = HttpStatus.NOT_FOUND;

    public EMailNotFoundException(String email) {
        super(String.format(errorMsg,email));
    }
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
