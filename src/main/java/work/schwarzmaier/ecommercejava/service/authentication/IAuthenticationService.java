package work.schwarzmaier.ecommercejava.service.authentication;

import work.schwarzmaier.ecommercejava.service.common.exceptions.EMailAlreadyExitsException;
import work.schwarzmaier.ecommercejava.service.common.exceptions.EMailNotFoundException;

public interface IAuthenticationService {

    AuthenticationResult login(String email, String password) throws EMailNotFoundException;


    AuthenticationResult register(String firstName, String lastName, String email, String password) throws EMailAlreadyExitsException;
}
