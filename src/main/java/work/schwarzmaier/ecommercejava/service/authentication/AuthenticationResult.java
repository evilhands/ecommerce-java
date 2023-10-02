package work.schwarzmaier.ecommercejava.service.authentication;

public record AuthenticationResult(Long id, String firstName, String lastName, String email, String token) {
}
