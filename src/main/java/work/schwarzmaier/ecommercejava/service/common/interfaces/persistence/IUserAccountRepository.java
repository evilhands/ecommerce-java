package work.schwarzmaier.ecommercejava.service.common.interfaces.persistence;

import work.schwarzmaier.ecommercejava.service.user.UserAccount;

import java.util.Optional;

public interface IUserAccountRepository {

    UserAccount add(UserAccount userAccount);

    Optional<UserAccount> findByEmail(String email);
}
