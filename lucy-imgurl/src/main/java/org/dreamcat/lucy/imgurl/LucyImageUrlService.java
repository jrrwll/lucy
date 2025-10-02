package org.dreamcat.lucy.imgurl;

import org.dreamcat.rita.renderer.ResponseEntity;

/**
 * Create by tuke on 2021/1/7
 */
public interface LucyImageUrlService {

    ResponseEntity<?> download(int year, int month, String name);
}
