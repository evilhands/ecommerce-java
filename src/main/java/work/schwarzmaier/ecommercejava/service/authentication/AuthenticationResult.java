package work.schwarzmaier.ecommercejava.service.authentication;

import work.schwarzmaier.ecommercejava.service.user.UserAccount;

public record AuthenticationResult(UserAccount userAccount, String token) {
}
