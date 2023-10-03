package work.schwarzmaier.ecommercejava.api.authentication;

record RegisterRequest(String firstName, String lastName, String email, String password) {
}
