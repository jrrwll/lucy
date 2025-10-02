package org.dreamcat.lucy.imgurl;

import lombok.Data;
import org.dreamcat.rita.annotation.InjectedProperties;

/**
 * Create by tuke on 2021/1/7
 */
@Data
@InjectedProperties("app")
public class LucyImageUrlProperties {

    private String basePath;
}
