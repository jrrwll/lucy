package org.dreamcat.lucy.imgurl;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Create by tuke on 2021/1/7
 */
@Data
@ConfigurationProperties(prefix = "app")
public class LucyImageUrlProperties {

    private String basePath;
}
