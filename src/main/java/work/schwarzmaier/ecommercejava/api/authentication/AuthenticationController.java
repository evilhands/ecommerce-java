package work.schwarzmaier.ecommercejava.api.authentication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import work.schwarzmaier.ecommercejava.service.authentication.AuthenticationResult;
import work.schwarzmaier.ecommercejava.service.authentication.IAuthenticationService;
import work.schwarzmaier.ecommercejava.service.common.exceptions.EMailAlreadyExitsException;
import work.schwarzmaier.ecommercejava.service.common.exceptions.EMailNotFoundException;

@RestController
@RequestMapping("auth")
class AuthenticationController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final IAuthenticationService authenticationService;

    public AuthenticationController(IAuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping("login")
    public ResponseEntity<AuthenticationResult> login(@RequestBody LoginRequest loginRequest) {
        try {
            return ResponseEntity.ok(authenticationService.login(loginRequest.email(), loginRequest.password()));
        } catch (EMailNotFoundException e) {
            logger.info(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("register")
    public ResponseEntity<AuthenticationResult> register(@RequestBody RegisterRequest registerRequest)  {
        // valid password and email
        // not null field
        try {
            return ResponseEntity.ok(authenticationService.register(registerRequest.firstName(), registerRequest.lastName(), registerRequest.email(), registerRequest.password()));
        } catch (EMailAlreadyExitsException e) {
            logger.info(e.getMessage());
            return ResponseEntity.status(e.getHttpStatus()).build();
        }
    }
}
