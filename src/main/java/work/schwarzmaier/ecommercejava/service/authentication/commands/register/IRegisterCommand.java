package work.schwarzmaier.ecommercejava.service.authentication.commands.register;

import work.schwarzmaier.ecommercejava.service.authentication.common.AuthenticationResult;
import work.schwarzmaier.ecommercejava.service.common.exceptions.EMailAlreadyExitsException;

public interface IRegisterCommand {

    AuthenticationResult register(String firstName, String lastName, String email, String password) throws EMailAlreadyExitsException;
}
