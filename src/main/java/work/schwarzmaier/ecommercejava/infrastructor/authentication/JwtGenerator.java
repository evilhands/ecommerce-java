package work.schwarzmaier.ecommercejava.infrastructor.authentication;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import work.schwarzmaier.ecommercejava.service.common.interfaces.authentication.IJwtGenerator;
import work.schwarzmaier.ecommercejava.infrastructor.service.DateTime;
import work.schwarzmaier.ecommercejava.service.user.UserAccount;

import java.util.UUID;

@Component
class JwtGenerator implements IJwtGenerator {

    private static final Logger logger = LoggerFactory.getLogger(JwtGenerator.class);

    private final JwtSettings jwtSettings;

    public JwtGenerator(JwtSettings jwtSettings) {
        this.jwtSettings = jwtSettings;
    }

    @Override
    public String generate(UserAccount userAccount){
        String token = "";
        try {
            Algorithm algorithm = Algorithm.HMAC384(jwtSettings.getSecret());
            token = JWT.create()
                    .withIssuer(jwtSettings.getIssuer())
                    .withSubject(String.valueOf(userAccount.getId()))
                    .withAudience(jwtSettings.getAudience())
                    .withClaim("firstName",userAccount.getFirstName())
                    .withClaim("lastName",userAccount.getLastName())
                    .withJWTId(UUID.randomUUID().toString())
                    .withExpiresAt(DateTime.UTCplusMin(jwtSettings.getExpiryMinutes()))
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            logger.error(exception.getMessage());
        }
        return token;
    }
}
