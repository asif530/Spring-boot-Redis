package com.ishtahad.springbootcrudredisexample;

import com.ishtahad.springbootcrudredisexample.entity.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

@SpringBootApplication
@EnableCaching
public class SpringBootCrudRedisExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCrudRedisExampleApplication.class, args);
    }

    /*@Bean
    public RedisCacheConfiguration cacheConfiguration() {
        return RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(1))
                .disableCachingNullValues()
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
    }*/

    /*@Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory();
    }*/

    /*@Bean
    public RedisTemplate<String, Product> redisTemplate(){
        RedisTemplate<String, Product> productTemplate = new RedisTemplate<>();
        productTemplate.setConnectionFactory(redisConnectionFactory());
        return productTemplate;
    }*/

}
