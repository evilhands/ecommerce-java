package work.schwarzmaier.ecommercejava.service.authentication;

import org.springframework.stereotype.Service;
import work.schwarzmaier.ecommercejava.service.common.authentication.JwtGenerator;

import java.util.Random;

@Service
public class AuthenticationService {

    private final JwtGenerator jwtGenerator;

    public AuthenticationService(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }

    public AuthenticationResult login(String username, String password){
        return  new AuthenticationResult(1L, "firstname", "lastName", username, "was");
    }


    public AuthenticationResult register(String firstName, String lastName, String email, String password){
        String token = jwtGenerator.generate(new Random().nextLong(), firstName, lastName);
        return  new AuthenticationResult(1L, firstName, lastName, email, token);
    }
}
