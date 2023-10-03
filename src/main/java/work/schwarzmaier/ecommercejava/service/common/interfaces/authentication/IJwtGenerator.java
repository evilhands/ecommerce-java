package work.schwarzmaier.ecommercejava.service.common.interfaces.authentication;

import work.schwarzmaier.ecommercejava.service.user.UserAccount;

public interface IJwtGenerator {
    String generate(UserAccount userAccount);
}