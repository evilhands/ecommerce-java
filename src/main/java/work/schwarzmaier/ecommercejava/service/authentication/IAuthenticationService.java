package work.schwarzmaier.ecommercejava.service.authentication;

public interface IAuthenticationService {

    AuthenticationResult login(String email, String password) throws Exception;


    AuthenticationResult register(String firstName, String lastName, String email, String password) throws Exception;
}
