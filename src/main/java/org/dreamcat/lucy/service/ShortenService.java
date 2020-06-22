package org.dreamcat.lucy.service;

/**
 * Create by tuke on 2020/5/13
 */
public interface ShortenService {

    String shorten(String url, int ttl, String password, String token);

}
