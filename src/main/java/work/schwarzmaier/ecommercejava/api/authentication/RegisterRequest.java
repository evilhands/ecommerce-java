package work.schwarzmaier.ecommercejava.api.authentication;

public record RegisterRequest(String firstName, String lastName, String email, String password) {
}
