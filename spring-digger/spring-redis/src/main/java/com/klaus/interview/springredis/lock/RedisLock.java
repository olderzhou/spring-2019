package com.klaus.interview.springredis.lock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class RedisLock {

    private String lock_key = "redis_lock"; //锁键

    @Autowired
    private RedisTemplate redisTemplate;

    private static final Long RELEASE_LOCK_SUCCESS_RESULT = 1L;
    /**
     * 加锁
     * @param id
     * @return
     */
    public boolean lock(String id, long timeout){
        Long start = System.currentTimeMillis();
        try {
            while (true) {
                log.info("trying to get lock");
                boolean result = redisTemplate.opsForValue().setIfAbsent(lock_key, id, 1, TimeUnit.MINUTES);
                if (result) {
                    log.info("get lock success!!!");
                    return true;
                }
                if (System.currentTimeMillis() - start >= timeout)
                    return false;
                Thread.sleep(1000L);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }


    /**
     * 解锁
     * @param id
     * @return
     */
    public boolean unlock(String id){
        String script = "if redis.call('get',KEYS[1]) == ARGV[1] then return redis.call('del',KEYS[1]) else return 0 end";
        boolean result = redisTemplate.execute(RedisScript.of(script, Long.class),Collections.singletonList(lock_key), id)
                .equals(RELEASE_LOCK_SUCCESS_RESULT);
        log.info("releasing lock");
        return result;
    }


}
