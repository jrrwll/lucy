package org.dreamcat.lucy.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Create by tuke on 2020/6/4
 */
@Data
@ConfigurationProperties(prefix = "app")
public class AppProperties {

    private Shorten shorten = new Shorten();
    private ImageUrl imageUrl = new ImageUrl();

    @Data
    public static class Shorten {

        private int minWidth = 3;
        private int desiredMaxWidth = 6;
        private int maxWidth = 12;
        private int unauthorizedMaxTtl = 3 * 30 * 24 * 3600; // three months
    }

    @Data
    public static class ImageUrl {

        private String basePath;
    }
}
