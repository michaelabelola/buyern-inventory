package com.buyern.inventory.authorization;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@RedisHash(value = "userSessions", timeToLive = 2592000L)
@Data
public class UserSession implements Serializable {
    /**
     * <h3>userId</h3>
     */
    @Id
    private String id;

    private String jwtId;
    private String firstName;
    private String lastName;
    private boolean verified = false;
    private boolean disabled = false;
    private boolean expired = false;
    private boolean credentialExpired = false;
    private boolean locked = false;
    private Date loginTime;
    private List<CustomAuthority> authorities;
}
