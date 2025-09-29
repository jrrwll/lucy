package org.dreamcat.lucy.config;

import org.dreamcat.common.web.handler.RestExceptionHandler;
import org.dreamcat.rita.annotation.Provider;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

/**
 * Create by tuke on 2020/5/13
 */
@EnableConfigurationProperties({AppProperties.class})
@Import({RestExceptionHandler.class})
@Provider
public class AppConfig {

    public static final String API_VERSION = "/api/v1";
}
