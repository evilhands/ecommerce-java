package work.schwarzmaier.ecommercejava.service.authentication;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public AuthenticationResult login(String username, String password){
        return  new AuthenticationResult(Long.valueOf(1), "firstname", "Lastname", "username", "was");
    }


    public AuthenticationResult register(String firstname, String lastname, String email, String password){
        return  new AuthenticationResult(Long.valueOf(1), firstname, lastname, email, "was");
    }
}
