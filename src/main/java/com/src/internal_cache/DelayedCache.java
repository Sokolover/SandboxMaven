package com.src.internal_cache;

import java.lang.ref.SoftReference;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * We can easily store some calculated operations results in order to reduce
 * re-calculation time.
 *
 * @author osmanyasal
 */
public class DelayedCache implements Cache {

    private final ConcurrentHashMap<String, SoftReference<Object>> cache;
    private final DelayQueue<DelayedCacheObject> cleaningUpQueue;
    private Thread cleanerThread;

    public DelayedCache() {
        cache = new ConcurrentHashMap<>();
        cleaningUpQueue = new DelayQueue<>();
        initCleanerThread();
    }

    /**
     * demon cleaner thread, clears the items of the cache that its time is exceeded
     */
    private void initCleanerThread() {
        this.cleanerThread = new Thread(() -> {
            DelayedCacheObject delayedCacheObject;
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    delayedCacheObject = this.cleaningUpQueue.take();
                    this.cache.remove(delayedCacheObject.getKey(), delayedCacheObject.getReference());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        this.cleanerThread.setDaemon(true);
        this.cleanerThread.start();
    }

    @Override
    public void add(String key, Object value, long time, TimeUnit timeUnit) {
        if (key == null) {
            return;
        }
        if (value == null) {
            cache.remove(key);
        } else {
            long expiryTime = System.currentTimeMillis() + TimeUnit.MILLISECONDS.convert(time, timeUnit);
            SoftReference<Object> reference = new SoftReference<>(value);
            cache.put(key, reference);
            cleaningUpQueue.put(new DelayedCacheObject(key, reference, expiryTime));
        }
    }

    @Override
    public void remove(String key) {
        cache.remove(key);
    }

    @Override
    public Object get(String key) {
        return Optional.ofNullable(cache.get(key)).map(SoftReference::get).orElse(null);
    }

    @Override
    public void clear() {
        cache.clear();
    }

    @Override
    public long size() {
        return cache.size();
    }

}