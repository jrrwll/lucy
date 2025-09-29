package org.dreamcat.lucy.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.dreamcat.lucy.service.NetworkService;
import org.dreamcat.rita.annotation.Provider;
import org.dreamcat.rita.http.Request;

/**
 * Create by tuke on 2020/6/22
 */
@Slf4j
@Provider
public class NetworkServiceImpl implements NetworkService {

    @Override
    public String detectIP(Request request) {
        var ip = request.getHeader("X-Real-IP");
        if (ip != null) return ip;
        return request.getRemoteAddr();
    }

}
