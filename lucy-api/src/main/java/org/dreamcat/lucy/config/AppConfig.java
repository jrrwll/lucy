package org.dreamcat.lucy.config;

import org.dreamcat.common.web.handler.RestExceptionHandler;
import org.dreamcat.rita.annotation.Provider;
import org.springframework.context.annotation.Import;

/**
 * Create by tuke on 2020/5/13
 */
@Import({RestExceptionHandler.class})
@Provider
public class AppConfig {

    public static final String API_VERSION = "/api/v1";
}
