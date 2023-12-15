package work.schwarzmaier.ecommercejava.service.authentication.queries.login;

import org.springframework.stereotype.Service;
import work.schwarzmaier.ecommercejava.service.authentication.common.AuthenticationResult;
import work.schwarzmaier.ecommercejava.service.common.exceptions.EMailNotFoundException;
import work.schwarzmaier.ecommercejava.service.common.interfaces.authentication.IJwtGenerator;
import work.schwarzmaier.ecommercejava.service.common.interfaces.persistence.IUserAccountRepository;
import work.schwarzmaier.ecommercejava.service.user.UserAccount;

import java.util.Optional;

@Service
class LoginQuery implements ILoginQuery {

    private final IJwtGenerator jwtGenerator;
    private final IUserAccountRepository userAccountRepository;

    public LoginQuery(IJwtGenerator jwtGenerator, IUserAccountRepository userAccountRepository) {
        this.jwtGenerator = jwtGenerator;
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public AuthenticationResult login(String email, String password) throws EMailNotFoundException {

        Optional<UserAccount> userAccountOptional = userAccountRepository.findByEmail(email);
        if (userAccountOptional.isEmpty()) {
            throw new EMailNotFoundException(email);
        }

        UserAccount userAccount = userAccountOptional.get();
        String token = jwtGenerator.generate(userAccount);

        return new AuthenticationResult(userAccount, token);
    }

}
