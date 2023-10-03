package work.schwarzmaier.ecommercejava.infrastructor.authentication;

import org.springframework.stereotype.Component;
import work.schwarzmaier.ecommercejava.service.common.interfaces.authentication.IJwtGenerator;

@Component
class TestGenerator implements IJwtGenerator {
    @Override
    public String generate(Long id, String firstName, String lastName) {
        return "test";
    }
}
