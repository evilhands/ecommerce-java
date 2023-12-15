package work.schwarzmaier.ecommercejava.service.authentication.queries.login;

import work.schwarzmaier.ecommercejava.service.authentication.common.AuthenticationResult;
import work.schwarzmaier.ecommercejava.service.common.exceptions.EMailNotFoundException;

public interface ILoginQuery {

    AuthenticationResult login(String email, String password) throws EMailNotFoundException;
}
