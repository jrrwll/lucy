package org.dreamcat.lucy.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Create by tuke on 2020/6/4
 */
@Data
@ConfigurationProperties(prefix = "app")
public class AppProperties {
    private Hash hash = new Hash();

    @Data
    public static class Hash {
        private int minWidth = 3;
        private int desiredMaxWidth = 6;
    }
}
