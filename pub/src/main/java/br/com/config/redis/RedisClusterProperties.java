package br.com.config.redis;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties(prefix = "spring.redis.cluster")
@PropertySource("classpath:redis.properties")
public class RedisClusterProperties {
	@Getter
	@Setter
	List<String> nodes;
}
