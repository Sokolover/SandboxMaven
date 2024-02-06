package com.src.internal_cache;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.lang.ref.SoftReference;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
class DelayedCacheObject implements Delayed {

    @Getter
    private final String key;
    @Getter
    private final SoftReference<Object> reference;
    private final long expiryTime;

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(expiryTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return Long.compare(expiryTime, ((DelayedCacheObject) o).expiryTime);
    }
}
