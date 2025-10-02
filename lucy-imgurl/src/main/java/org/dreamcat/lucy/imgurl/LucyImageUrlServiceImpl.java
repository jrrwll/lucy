package org.dreamcat.lucy.imgurl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dreamcat.rita.annotation.Provider;
import org.dreamcat.rita.renderer.ResponseEntity;

import java.io.File;

/**
 * Create by tuke on 2021/1/7
 */
@Slf4j
@Provider
@RequiredArgsConstructor
public class LucyImageUrlServiceImpl implements LucyImageUrlService {

    private final LucyImageUrlProperties properties;

    @Override
    public ResponseEntity<?> download(int year, int month, String name) {
        String path = String.format("%s/%d/%d/%s", properties.getBasePath(), year, month, name);
        File file = new File(path);
        if (!file.exists()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(file);
    }
}
