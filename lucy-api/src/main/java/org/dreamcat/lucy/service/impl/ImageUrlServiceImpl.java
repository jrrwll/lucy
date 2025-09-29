package org.dreamcat.lucy.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dreamcat.lucy.config.AppProperties;
import org.dreamcat.lucy.service.ImageUrlService;
import org.dreamcat.rita.annotation.Provider;
import org.dreamcat.rita.web.MultipartFile;

/**
 * Create by tuke on 2021/1/7
 */
@Slf4j
@Provider
@RequiredArgsConstructor
public class ImageUrlServiceImpl implements ImageUrlService {

    private final AppProperties properties;

    @Override
    public void upload(MultipartFile file, String token) {


        String basePath = properties.getImageUrl().getBasePath();

    }
}
