package work.schwarzmaier.ecommercejava.service.common.interfaces.authentication;

public interface IJwtGenerator {
    public String generate(Long id, String firstName, String lastName);
}