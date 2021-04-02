package org.dreamcat.lucy.imgurl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Create by tuke on 2021/1/7
 */
@EnableConfigurationProperties({LucyImageUrlProperties.class})
@SpringBootApplication
public class LucyImageUrlApplication {
    public static void main(String[] args) {
        SpringApplication.run(LucyImageUrlApplication.class, args);
    }
}
