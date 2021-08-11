package org.javadev.app.redis;

import lombok.Data;
import java.io.Serializable;

@Data
public class RedisUser implements Serializable{
    
    private String id;
    private String firstName;
    private String lastName;

    public RedisUser() {
    }

    public RedisUser(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public RedisUser(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
