package org.dreamcat.lucy.service;

import org.dreamcat.rita.web.MultipartFile;

/**
 * Create by tuke on 2021/1/7
 */
public interface ImageUrlService {

    void upload(MultipartFile file, String token);
}
