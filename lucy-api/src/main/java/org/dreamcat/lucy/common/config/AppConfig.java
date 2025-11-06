package org.dreamcat.lucy.common.config;

import org.dreamcat.common.web.exception.RitaApiExceptionHandler;
import org.dreamcat.rita.annotation.Provider;

/**
 * Create by tuke on 2020/5/13
 */
@Provider
public class AppConfig {

    @Provider
    public RitaApiExceptionHandler ritaApiExceptionHandler() {
        return new RitaApiExceptionHandler();
    }
}
