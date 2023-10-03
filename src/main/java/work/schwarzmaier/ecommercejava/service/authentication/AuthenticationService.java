package work.schwarzmaier.ecommercejava.service.authentication;

import org.springframework.stereotype.Service;
import work.schwarzmaier.ecommercejava.service.common.interfaces.authentication.IJwtGenerator;
import work.schwarzmaier.ecommercejava.service.common.interfaces.persistence.IUserAccountRepository;
import work.schwarzmaier.ecommercejava.service.user.UserAccount;

import java.util.Optional;

@Service
class AuthenticationService implements IAuthenticationService {

    private final IJwtGenerator jwtGenerator;
    private final IUserAccountRepository userAccountRepository;

    public AuthenticationService(IJwtGenerator jwtGenerator, IUserAccountRepository userAccountRepository) {
        this.jwtGenerator = jwtGenerator;
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public AuthenticationResult login(String email, String password) throws Exception {

        Optional<UserAccount> userAccountOptional = userAccountRepository.findByEmail(email);
        if (userAccountOptional.isEmpty()) {
            throw new Exception("Can not find E-Mail");
        }

        UserAccount userAccount = userAccountOptional.get();
        String token = jwtGenerator.generate(userAccount);

        return new AuthenticationResult(userAccount, "was");
    }

    @Override
    public AuthenticationResult register(String firstName, String lastName, String email, String password) throws Exception {

        Optional<UserAccount> userAccountOptional = userAccountRepository.findByEmail(email);
        if (userAccountOptional.isPresent()) {
            throw new Exception("Given E-Mail Address is already used");
        }

        UserAccount userAccount = userAccountRepository.add(new UserAccount(firstName, lastName, email, password));

        String token = jwtGenerator.generate(userAccount);
        return new AuthenticationResult(userAccount, token);
    }
}
