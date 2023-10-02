package work.schwarzmaier.ecommercejava.api.contract.authentication;

public record RegisterRequest(String firstname, String lastname, String email, String password) {
}
