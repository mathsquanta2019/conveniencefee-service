package com.safemtech.conveniencefeeservice.client;

/**
 * Utility method to insert data into map to limit network calls.
 * This is a functional interface and each service can implement this based on specific caching requirements.
 *
 */
public interface CacheClient {
    String cacheData(Object data, String mapName, String id);
}
