package com.project.cache;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static net.sf.ehcache.CacheManager.create;

@Configuration
@EnableCaching
public class CacheConfig {

    private net.sf.ehcache.CacheManager cacheManager;

    @Bean
    public CacheManager ejwCacheManager() {
        cacheManager = create();
        cacheManager.getConfiguration().setMaxBytesLocalHeap("16m"); // size from xml
        // java heap

        EhCacheCacheManager ehCacheCacheManager = new EhCacheCacheManager();
        ehCacheCacheManager.setCacheManager(cacheManager);
        return ehCacheCacheManager;
    }

}
