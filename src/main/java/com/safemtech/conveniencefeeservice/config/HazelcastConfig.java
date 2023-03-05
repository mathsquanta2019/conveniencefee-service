package com.safemtech.conveniencefeeservice.config;

import com.hazelcast.config.ClasspathXmlConfig;
import com.hazelcast.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Hazelcast Config class. hazelcast.xml is required in the classpath for this to work.
 */
@Configuration
public class HazelcastConfig {

    /**
     *
     * @return Config object.
     */
    @Bean
    public Config cacheConfig(){
        return new ClasspathXmlConfig("hazelcast.xml");
    }
}
