package work.schwarzmaier.ecommercejava.service.authentication;

import org.springframework.stereotype.Service;
import work.schwarzmaier.ecommercejava.service.common.authentication.IJwtGenerator;

import java.util.Random;

@Service
class AuthenticationService implements  IAuthenticationService{

    private final IJwtGenerator testGenerator;

    public AuthenticationService(IJwtGenerator testGenerator) {
        this.testGenerator = testGenerator;
    }

    public AuthenticationResult login(String username, String password){
        return  new AuthenticationResult(1L, "firstname", "lastName", username, "was");
    }

    public AuthenticationResult register(String firstName, String lastName, String email, String password){
        String token = testGenerator.generate(new Random().nextLong(), firstName, lastName);
        return  new AuthenticationResult(1L, firstName, lastName, email, token);
    }
}
