package work.schwarzmaier.ecommercejava.service.authentication;

public record AuthenticationResult(Long id, String firstname, String lastname, String email, String token) {
}
