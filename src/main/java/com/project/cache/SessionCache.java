package com.project.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

@Component("sessionCache")
public class SessionCache extends AbstractCache {

    private final String cacheName = "sessionCache";

    @Autowired
    private CacheManager cacheManager;

    @Override
    public CacheManager getCacheManager() {
        return cacheManager;
    }

    @Override
    public String getCacheName() {
        return cacheName;
    }
}
