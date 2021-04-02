package org.dreamcat.lucy.imgurl;

import org.springframework.http.ResponseEntity;

/**
 * Create by tuke on 2021/1/7
 */
public interface LucyImageUrlService {

    ResponseEntity<?> download(int year, int month, String name);
}
