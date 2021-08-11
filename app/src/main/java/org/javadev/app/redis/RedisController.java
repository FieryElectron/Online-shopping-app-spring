package org.javadev.app.redis;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;

@Controller
public class RedisController {
    private RedisTemplate<String, RedisUser> redisTemplate;

    private HashOperations hashOperations;
    private ValueOperations valueOperations;

    public RedisController( RedisTemplate<String, RedisUser> redisTemplate) {
        this.redisTemplate = redisTemplate;

        hashOperations = redisTemplate.opsForHash();
        valueOperations = redisTemplate.opsForValue();

        // valueOperations.set("newkey!", "value");

        // String res = (String)valueOperations.get("newkey!");

        // System.out.println("########### Redis ##########");
        // System.out.println(res);

    }
}
