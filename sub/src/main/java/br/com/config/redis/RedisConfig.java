package br.com.config.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {
	private final RedisClusterProperties clusterProperties;

	@Value("${redis.cluster-support}")
	private boolean clusterSupport;

	@Value("${redis.host}")
	private String redisHost;

	@Value("${redis.port}")
	private int redisPort;

	@Autowired
	public RedisConfig(RedisClusterProperties clusterProperties) {
		super();
		this.clusterProperties = clusterProperties;
	}

	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
		return getJedisFactory();
	}

	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(jedisConnectionFactory());
		return template;
	}
	
	@Bean
	public RedisTemplate<String, Integer> redisTemplateLong() {
		RedisTemplate<String, Integer> template = new RedisTemplate<>();
		template.setConnectionFactory(jedisConnectionFactory());
		return template;
	}

	private JedisConnectionFactory getJedisFactory() {
		JedisConnectionFactory jedisConnectionFactory = null;

		if (clusterSupport) {
			RedisClusterConfiguration configuration = new RedisClusterConfiguration(clusterProperties.getNodes());
			jedisConnectionFactory = new JedisConnectionFactory(configuration);
		} else {
			jedisConnectionFactory = new JedisConnectionFactory();
			jedisConnectionFactory.setHostName(redisHost);
			jedisConnectionFactory.setPort(redisPort);
		}

		return jedisConnectionFactory;
	}
}
