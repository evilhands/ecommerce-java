package work.schwarzmaier.ecommercejava.infrastructor.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import work.schwarzmaier.ecommercejava.service.common.interfaces.persistence.IUserAccountRepository;
import work.schwarzmaier.ecommercejava.service.user.UserAccount;

import java.util.Optional;

interface CrudRepo extends CrudRepository<UserAccount, Long> {
    Optional<UserAccount> findByEmail(String email);
}

@Repository
public class UserAccountRepository implements IUserAccountRepository {


    @Autowired
    private CrudRepo crudRepo;

    @Override
    public UserAccount add(UserAccount userAccount) {
        return crudRepo.save(userAccount);
    }

    @Override
    public Optional<UserAccount> findByEmail(String email) {
        return crudRepo.findByEmail(email);
    }
}
