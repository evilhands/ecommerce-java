package work.schwarzmaier.ecommercejava.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import work.schwarzmaier.ecommercejava.api.contract.authentication.RegisterRequest;
import work.schwarzmaier.ecommercejava.api.contract.authentication.LoginRequest;
import work.schwarzmaier.ecommercejava.service.authentication.AuthenticationResult;
import work.schwarzmaier.ecommercejava.service.authentication.AuthenticationService;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping("login")
    public AuthenticationResult login(LoginRequest loginRequest){
        return authenticationService.login(loginRequest.username(), loginRequest.password());
    }

    @GetMapping("register")
    public AuthenticationResult register(@RequestBody RegisterRequest registerRequest){
        // valid password and email
        // not null field
        return authenticationService.register(registerRequest.firstName(), registerRequest.lastName(), registerRequest.email(), registerRequest.password());
    }
}
