package work.schwarzmaier.ecommercejava.api.authentication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import work.schwarzmaier.ecommercejava.service.authentication.commands.register.IRegisterCommand;
import work.schwarzmaier.ecommercejava.service.authentication.common.AuthenticationResult;
import work.schwarzmaier.ecommercejava.service.authentication.queries.login.ILoginQuery;
import work.schwarzmaier.ecommercejava.service.common.exceptions.EMailAlreadyExitsException;
import work.schwarzmaier.ecommercejava.service.common.exceptions.EMailNotFoundException;

@RestController
@RequestMapping("auth")
class AuthenticationController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final IRegisterCommand registerCommand;
    private final ILoginQuery loginQuery;

    public AuthenticationController(IRegisterCommand registerCommand, ILoginQuery loginQuery) {
        this.registerCommand = registerCommand;
        this.loginQuery = loginQuery;
    }

    @PostMapping("login")
    public ResponseEntity<AuthenticationResult> login(@RequestBody LoginRequest loginRequest) {
        try {
            return ResponseEntity.ok(loginQuery.login(loginRequest.email(), loginRequest.password()));
        } catch (EMailNotFoundException e) {
            logger.info(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("register")
    public ResponseEntity<AuthenticationResult> register(@RequestBody RegisterRequest registerRequest) {
        // valid password and email
        // not null field
        try {
            return ResponseEntity.ok(registerCommand.register(registerRequest.firstName(), registerRequest.lastName(), registerRequest.email(), registerRequest.password()));
        } catch (EMailAlreadyExitsException e) {
            logger.info(e.getMessage());
            return ResponseEntity.status(e.getHttpStatus()).build();
        }
    }
}
