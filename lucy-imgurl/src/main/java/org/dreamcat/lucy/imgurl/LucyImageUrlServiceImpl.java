package org.dreamcat.lucy.imgurl;

import java.io.File;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Create by tuke on 2021/1/7
 */
@Slf4j
@Service
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
        return ResponseEntity.ok(new FileSystemResource(file));
    }
}
