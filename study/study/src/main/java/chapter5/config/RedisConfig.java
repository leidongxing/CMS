package chapter5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import chapter5.pojo.Product;

@Configuration
public class RedisConfig {
   @Bean
   public RedisConnectionFactory redisCF(){
	   return new JedisConnectionFactory();
   }
   
   @Bean
   public RedisTemplate<String,Product> redisTemplate(RedisConnectionFactory cf){
	   RedisTemplate<String,Product> redis = new RedisTemplate<String,Product>();
	   redis.setConnectionFactory(cf);
	   redis.setKeySerializer(new StringRedisSerializer());
	   redis.setValueSerializer(new Jackson2JsonRedisSerializer<Product>(Product.class));
	   return redis;
   }
}
