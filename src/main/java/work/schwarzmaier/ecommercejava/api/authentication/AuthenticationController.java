package work.schwarzmaier.ecommercejava.api.authentication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import work.schwarzmaier.ecommercejava.service.authentication.AuthenticationResult;
import work.schwarzmaier.ecommercejava.service.authentication.IAuthenticationService;

@RestController
@RequestMapping("auth")
class AuthenticationController {

    private final IAuthenticationService authenticationService;

    public AuthenticationController(IAuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping("login")
    public AuthenticationResult login(@RequestBody LoginRequest loginRequest) throws Exception {
        return authenticationService.login(loginRequest.email(), loginRequest.password());
    }

    @GetMapping("register")
    public AuthenticationResult register(@RequestBody RegisterRequest registerRequest) throws Exception {
        // valid password and email
        // not null field
        return authenticationService.register(registerRequest.firstName(), registerRequest.lastName(), registerRequest.email(), registerRequest.password());
    }
}
