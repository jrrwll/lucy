package org.dreamcat.lucy.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Create by tuke on 2021/1/7
 */
public interface ImageUrlService {

    void upload(MultipartFile file, String token);
}
