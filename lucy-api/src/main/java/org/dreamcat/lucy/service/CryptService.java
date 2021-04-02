package org.dreamcat.lucy.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Create by tuke on 2020/5/13
 */
public interface CryptService {

    String encrypt(String text, String algorithm, String key);

    String decrypt(String text, String algorithm, String key);

    String sign(String text, String algorithm, String key, String format);

    String signFile(MultipartFile file, String algorithm, String key, String format);

}
