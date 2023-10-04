package work.schwarzmaier.ecommercejava.service.common.exceptions;

import org.springframework.http.HttpStatus;

public class EMailAlreadyExitsException extends Exception {

    private static final String errorMsg = "Given E-Mail Address is already used. E-Mail: %s";
    private static final HttpStatus httpStatus = HttpStatus.NOT_ACCEPTABLE;

    public EMailAlreadyExitsException(String email) {
        super(String.format(errorMsg,email));
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
