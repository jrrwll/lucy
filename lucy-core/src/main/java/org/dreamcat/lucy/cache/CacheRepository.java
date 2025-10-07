package org.dreamcat.lucy.cache;

import org.dreamcat.rita.annotation.Injected;
import org.dreamcat.rita.annotation.Provider;
import redis.clients.jedis.Jedis;

/**
 * @author Jerry Will
 * @version 2025-10-07
 */
@Provider
public class CacheRepository {

    @Injected
    Jedis jedis;

    public String getShortenUrl(String md5) {
        return jedis.get("lucy:shorten_url:" + md5);
    }
}
