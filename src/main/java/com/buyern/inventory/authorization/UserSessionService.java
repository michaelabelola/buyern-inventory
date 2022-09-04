package com.buyern.inventory.authorization;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Service;

@Service
@Data
public class UserSessionService {
    private static final Logger logger = LoggerFactory.getLogger(UserSessionService.class);
    @Value("${jwt.secret}")
    private String SECRET;
    //    @Value("#{new Long('${custom.session.duration}')}")
    private static Long EXPIRATION_TIME = 2592000L;
    private static final String AUTH_TOKEN_PREFIX = "Bearer ";
    private static final String AUTH_HEADER_STRING = "Authorization";
    private final UserSessionRepository userSessionRepository;

    public void validateUserSession() {

    }

    public UserSession getSession(String userId) {
        return userSessionRepository.findById(userId).orElseThrow(() -> {
            logger.info("User Session Not found: try logging");
            return new SessionAuthenticationException("User Session Not found: try logging");
        });
    }

}
