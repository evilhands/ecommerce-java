package work.schwarzmaier.ecommercejava.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
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
    public AuthenticationResult register(RegisterRequest registerRequest){
        return authenticationService.register(registerRequest.firstname(), registerRequest.lastname(), registerRequest.email(), registerRequest.password())/**/;
    }
}