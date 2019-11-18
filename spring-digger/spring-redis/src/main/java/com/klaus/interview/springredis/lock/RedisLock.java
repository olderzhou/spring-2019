package com.klaus.interview.springredis.lock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.params.SetParams;

import java.util.Collections;

@Component
public class RedisLock {

    private String lock_key = "redis_lock"; //锁键

    protected long internalLockLeaseTime = 30000;//锁过期时间

    private long timeout = 60000; //获取锁的超时时间


    //SET命令的参数
    SetParams params = SetParams.setParams().nx().px(internalLockLeaseTime);

    private static final String LOCK_SUCCESS = "OK";

    @Autowired
    private JedisPool jedisPool;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 加锁
     * @param id
     * @return
     */
    public boolean lock(String id){
        Jedis jedis = jedisPool.getResource();
        Long start = System.currentTimeMillis();
        try {
            while (true) {
                String result = jedis.set(lock_key, id, params);
                if(LOCK_SUCCESS.equals(result)) {
                    return true;
                }
                if (System.currentTimeMillis() - start >= timeout)
                    return false;
                //return false;
            }
        } finally {
            jedis.close();
        }
    }


    /**
     * 解锁
     * @param id
     * @return
     */
    public boolean unlock(String id){
        Jedis jedis = jedisPool.getResource();
        String script = "if redis.call('get',KEYS[1]) == ARGV[1] then" +
                        "   return redis.call('del',KEYS[1]) " +
                        "else" +
                        "   return 0 " +
                        "end";
        try {
            Object result = jedis.eval(script, Collections.singletonList(lock_key),
                    Collections.singletonList(id));
            if("1".equals(result.toString())){
                return true;
            }
            return false;
        }finally {
            jedis.close();
        }
    }


}
