package work.schwarzmaier.ecommercejava.service.authentication;

public interface IAuthenticationService {

    public AuthenticationResult login(String username, String password);


    public AuthenticationResult register(String firstName, String lastName, String email, String password);
}
