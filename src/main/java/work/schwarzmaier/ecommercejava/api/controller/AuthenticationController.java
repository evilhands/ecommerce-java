package work.schwarzmaier.ecommercejava.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import work.schwarzmaier.ecommercejava.api.authentication.AuthenticationRespones;
import work.schwarzmaier.ecommercejava.api.common.mapper.AuthenticationMapper;
import work.schwarzmaier.ecommercejava.service.authentication.commands.register.IRegisterCommandService;
import work.schwarzmaier.ecommercejava.service.authentication.common.AuthenticationResult;
import work.schwarzmaier.ecommercejava.api.authentication.LoginRequest;
import work.schwarzmaier.ecommercejava.api.authentication.RegisterRequest;
import work.schwarzmaier.ecommercejava.service.authentication.queries.login.ILoginQueryService;
import work.schwarzmaier.ecommercejava.service.common.exceptions.EMailAlreadyExitsException;
import work.schwarzmaier.ecommercejava.service.common.exceptions.EMailNotFoundException;

@RestController
@RequestMapping("auth")
class AuthenticationController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final IRegisterCommandService registerCommandService;
    private final ILoginQueryService loginQueryService;

    public AuthenticationController(IRegisterCommandService registerCommandService, ILoginQueryService loginQueryService) {
        this.registerCommandService = registerCommandService;
        this.loginQueryService = loginQueryService;
    }

    @PostMapping("login")
    public ResponseEntity<AuthenticationRespones> login(@RequestBody LoginRequest loginRequest) {
        try {
            AuthenticationResult login = loginQueryService.login(loginRequest.email(), loginRequest.password());
            AuthenticationRespones respones = AuthenticationMapper.INSTANCE.toRespones(login);
            return ResponseEntity.ok(respones);
        } catch (EMailNotFoundException e) {
            logger.info(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("register")
    public ResponseEntity<AuthenticationRespones> register(@RequestBody RegisterRequest registerRequest) {
        // valid password and email
        // not null field
        try {
            AuthenticationResult result = registerCommandService.register(registerRequest.firstName(), registerRequest.lastName(), registerRequest.email(), registerRequest.password());
            AuthenticationRespones respones = AuthenticationMapper.INSTANCE.toRespones(result);
            return ResponseEntity.ok(respones);
        } catch (EMailAlreadyExitsException e) {
            logger.info(e.getMessage());
            return ResponseEntity.status(e.getHttpStatus()).build();
        }
    }
}
