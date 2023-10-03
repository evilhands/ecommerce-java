package work.schwarzmaier.ecommercejava.infrastructor.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import work.schwarzmaier.ecommercejava.service.common.interfaces.persistence.IUserAccountRepository;
import work.schwarzmaier.ecommercejava.service.user.UserAccount;

import java.util.Optional;

interface UserCrudRepo extends CrudRepository<UserAccount, Long> {
    Optional<UserAccount> findByEmail(String email);
}

@Repository
public class UserAccountRepository implements IUserAccountRepository {


    @Autowired
    private UserCrudRepo userCrudRepo;

    @Override
    public UserAccount add(UserAccount userAccount) {
        return userCrudRepo.save(userAccount);
    }

    @Override
    public Optional<UserAccount> findByEmail(String email) {
        return userCrudRepo.findByEmail(email);
    }
}
