package org.dreamcat.lucy.config;

import org.dreamcat.common.web.exception.RitaApiExceptionHandler;
import org.dreamcat.rita.annotation.Provider;

/**
 * Create by tuke on 2020/5/13
 */
@Provider
public class AppConfig {

    public static final String API_VERSION = "/api/v1";

    @Provider
    public RitaApiExceptionHandler ritaApiExceptionHandler() {
        return new RitaApiExceptionHandler();
    }
}
