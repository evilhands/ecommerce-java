package work.schwarzmaier.ecommercejava.api.contract.authentication;

public record RegisterRequest(String firstName, String lastName, String email, String password) {
}
