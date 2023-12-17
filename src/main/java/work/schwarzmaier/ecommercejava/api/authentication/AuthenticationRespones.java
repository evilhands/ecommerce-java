package work.schwarzmaier.ecommercejava.api.authentication;

public record AuthenticationRespones(Long id,String firstName, String lastName, String email, String password, String token) {
}
