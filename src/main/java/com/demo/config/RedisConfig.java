package com.demo.config;

import com.demo.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author lihao
 */
@Configuration
public class RedisConfig {
    /**配置redis的序列化器用于user的序列化
     * @param factory
     * @return
     */
    @Bean
    public RedisTemplate<String, User> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, User> template = new RedisTemplate<>();
        //关联
        template.setConnectionFactory(factory);
        //设置key的序列化
        template.setKeySerializer(new StringRedisSerializer());
        //设置value的序列化器为json
        template.setValueSerializer(new Jackson2JsonRedisSerializer(User.class));
        return template;
    }


}
