package work.schwarzmaier.ecommercejava.service.common.authentication;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("jwt-settings")
public class JwtSettings {

    private String secret;
    private Long expiryMinutes;
    private String issuer;
    private String audience;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Long getExpiryMinutes() {
        return expiryMinutes;
    }

    public void setExpiryMinutes(Long expiryMinutes) {
        this.expiryMinutes = expiryMinutes;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }
}
