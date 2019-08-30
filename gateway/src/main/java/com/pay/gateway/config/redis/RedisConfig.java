package com.pay.gateway.config.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.databind.ObjectMapper;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
/**
 * <p>redis核心配置类</p>
 * @author K
 * @data 2019-08-01
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
	Logger log = LoggerFactory.getLogger(RedisConfig.class);

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.timeout}")
    private int timeout;

    @Value("${spring.redis.pool.max-idle}")
    private int maxIdle;

    @Value("${spring.redis.pool.max-wait}")
    private long maxWaitMillis;
    @Bean
    public JedisPool redisPoolFactory() {
    	log.debug("JedisPool注入成功！！");
    	log.debug("redis地址：" + host + ":" + port);
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout);
        return jedisPool;
    }
    
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
    			log.debug("redisTemplate注入成功！！");
    	      RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
    	      template.setConnectionFactory(factory);
    	      Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
    	      ObjectMapper om = new ObjectMapper();
    	      om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
    	      jackson2JsonRedisSerializer.setObjectMapper(om);
    	      StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
    	      // key采用String的序列化方式
    	      template.setKeySerializer(stringRedisSerializer);
    	      // hash的key也采用String的序列化方式
    	      template.setHashKeySerializer(stringRedisSerializer);
    	      // value序列化方式采用jackson
    	      template.setValueSerializer(jackson2JsonRedisSerializer);
    	      // hash的value序列化方式采用jackson
    	      template.setHashValueSerializer(jackson2JsonRedisSerializer);
    	      template.afterPropertiesSet();
    	      return template;
    	  }
    /**
	 * Logger
	 */
 
	
	@Bean
	public KeyGenerator keyGenerator() {
		// 设置自动key的生成规则，配置spring boot的注解，进行方法级别的缓存
		// 使用：进行分割，可以很多显示出层级关系
		// 这里其实就是new了一个KeyGenerator对象，只是这是lambda表达式的写法，我感觉很好用，大家感兴趣可以去了解下
		return (target, method, params) -> {
			StringBuilder sb = new StringBuilder();
			sb.append(target.getClass().getName());
			sb.append(":");
			sb.append(method.getName());
			for (Object obj : params) {
				sb.append(":" + String.valueOf(obj));
			}
			String rsToUse = String.valueOf(sb);
			log.info("自动生成Redis Key -> [{}]", rsToUse);
			return rsToUse;
		};
	}
 

 
 
	@Override
	@Bean
	public CacheErrorHandler errorHandler() {
		// 异常处理，当Redis发生异常时，打印日志，但是程序正常走
		log.info("初始化 -> [{}]", "Redis CacheErrorHandler");
		CacheErrorHandler cacheErrorHandler = new CacheErrorHandler() {
			@Override
			public void handleCacheGetError(RuntimeException e, Cache cache, Object key) {
				log.error("Redis occur handleCacheGetError：key -> [{}]", key, e);
			}
			@Override
			public void handleCachePutError(RuntimeException e, Cache cache, Object key, Object value) {
				log.error("Redis occur handleCachePutError：key -> [{}]；value -> [{}]", key, value, e);
			}
			@Override
			public void handleCacheEvictError(RuntimeException e, Cache cache, Object key) {
				log.error("Redis occur handleCacheEvictError：key -> [{}]", key, e);
			}
			@Override
			public void handleCacheClearError(RuntimeException e, Cache cache) {
				log.error("Redis occur handleCacheClearError：", e);
			}
		};
		return cacheErrorHandler;
	}
}
