package com.example.demo;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Arrays;

@Configuration
@EnableCaching
@EnableScheduling
public class CacheConfiguration {
    @Bean
    public CacheManager cacheManager(){
        ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager();
        cacheManager.setAllowNullValues(false); // Esse método faz com que se o cache receber um valor nulo, não sera colocado no cache
        cacheManager.setCacheNames(Arrays.asList("productCache", "clienteCache")); // Os conjuntos de cache da RAM
        return cacheManager;
    }
}
