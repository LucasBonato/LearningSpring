package com.example.demo;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Arrays;

@Configuration
@EnableCaching
@EnableScheduling
public class CacheConfiguration {
    private static final int CINCO_MINUTOS = 5 * 60000;

    @Bean
    public CacheManager cacheManager(){
        ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager();
        cacheManager.setAllowNullValues(false); // Esse método faz com que se o cache receber um valor nulo, não sera colocado no cache
        cacheManager.setCacheNames(Arrays.asList("productCache", "clienteCache")); // Os conjuntos de cache da RAM
        return cacheManager;
    }

    @CacheEvict(value = "productCache", allEntries = true)
    @Scheduled(fixedDelay = CINCO_MINUTOS, initialDelay = 0) // A cada 5 segundos ele vai despejar os dados do banco no cache
    public void evictProductCache(){ }
}
