package com.rsel.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * map cache implementation
 * <p>
 * Created by 13 on 2017/2/7.
 */
public class MapCache {

	/**
	     * Default storage of 1024 caches
	     */
    private static final int DEFAULT_CACHES = 1024;

    private static final MapCache INS = new MapCache();

    public static MapCache single() {
        return INS;
    }

    /**
         * Cache container
         */
    private Map<String, CacheObject> cachePool;

    public MapCache() {
        this(DEFAULT_CACHES);
    }

    public MapCache(int cacheCount) {
        cachePool = new ConcurrentHashMap<>(cacheCount);
    }

    /**
         * Read a cache
         *
         * @param key cache key
         * @param <T>
         * @return
         */
    public <T> T get(String key) {
        CacheObject cacheObject = cachePool.get(key);
        if (null != cacheObject) {
            long cur = System.currentTimeMillis() / 1000;
            // Not expired directly return
            if (cacheObject.getExpired() <= 0 || cacheObject.getExpired() > cur) {
                Object result = cacheObject.getValue();
                return (T) result;
            }
          //Expired to delete directly
            if (cur > cacheObject.getExpired()) {
                cachePool.remove(key);
            }
        }
        return null;
    }

    /**
         * Read a hash type cache
         *
         * @param key cache key
         * @param field cache field
         * @param <T>
         * @return
         */
    public <T> T hget(String key, String field) {
        key = key + ":" + field;
        return this.get(key);
    }

    /**
         * Set a cache
         *
         * @param key cache key
         * @param value cache value
         */
    public void set(String key, Object value) {
        this.set(key, value, -1);
    }

    /**
         * Set a cache with expiration time
         *
         * @param key cache key
         * @param value cache value
         * @param expired expiration time in seconds
         */
    public void set(String key, Object value, long expired) {
        expired = expired > 0 ? System.currentTimeMillis() / 1000 + expired : expired;
        // When the cachePool is greater than 800, the buffer pool is forcibly cleared. This operation is somewhat rude and will cause accidental deletion. Later, consider replacing Redis with MapCache.
        if (cachePool.size() > 800) {
            cachePool.clear();
        }
        CacheObject cacheObject = new CacheObject(key, value, expired);
        cachePool.put(key, cacheObject);
    }

    /**
         * Set a hash cache
         *
         * @param key cache key
         * @param field cache field
         * @param value cache value
         */
    public void hset(String key, String field, Object value) {
        this.hset(key, field, value, -1);
    }

    /**
         * Set a hash cache with expiration time
         *
         * @param key cache key
         * @param field cache field
         * @param value cache value
         * @param expired expiration time in seconds
         */
    public void hset(String key, String field, Object value, long expired) {
        key = key + ":" + field;
        expired = expired > 0 ? System.currentTimeMillis() / 1000 + expired : expired;
        CacheObject cacheObject = new CacheObject(key, value, expired);
        cachePool.put(key, cacheObject);
    }

    /**
         * Delete cache based on key
         *
         * @param key cache key
         */
    public void del(String key) {
        cachePool.remove(key);
    }

    /**
         * Delete cache based on key and field
         *
         * @param key cache key
         * @param field cache field
         */
    public void hdel(String key, String field) {
        key = key + ":" + field;
        this.del(key);
    }

    /**
         * Empty the cache
         */
    public void clean() {
        cachePool.clear();
    }

    static class CacheObject {
        private String key;
        private Object value;
        private long expired;

        public CacheObject(String key, Object value, long expired) {
            this.key = key;
            this.value = value;
            this.expired = expired;
        }

        public String getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }

        public long getExpired() {
            return expired;
        }
    }
}