package com.project.cache;

import org.springframework.cache.CacheManager;

import static java.util.Optional.ofNullable;
import static org.springframework.cache.Cache.ValueWrapper;

public abstract class AbstractCache<KEY, VALUE> {

    protected abstract CacheManager getCacheManager();

    protected abstract String getCacheName();

    public void put(KEY key, VALUE value) {
        if (ofNullable(key).isPresent() && ofNullable(value).isPresent()) {
            ofNullable(getCacheManager().getCache(getCacheName()))
                    .orElseGet(() -> getCacheManager().getCache("ehCache")).put(key, value);
        }
    }

    public VALUE get(KEY key) {
        if (ofNullable(key).isPresent()) {
            ValueWrapper valueWrapper = ofNullable(getCacheManager().getCache(getCacheName()))
                    .orElseGet(() -> getCacheManager().getCache("ehCache")).get(key);
            return ofNullable(valueWrapper).map(val -> (VALUE) val.get()).orElse(null);
        }

        return null;
    }

    public void remove(KEY key) {
        ofNullable(key).ifPresent(cache -> getCacheManager().getCache("ehCache").evict(cache));
    }

    public boolean isEmpty() {
        return getCacheManager().getCacheNames().isEmpty();
    }
}
