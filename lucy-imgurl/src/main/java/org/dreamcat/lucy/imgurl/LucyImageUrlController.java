package org.dreamcat.lucy.imgurl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by tuke on 2021/1/7
 */
@RequiredArgsConstructor
@RestController
public class LucyImageUrlController {

    private final LucyImageUrlService service;

    @RequestMapping(path = "/{year:[0-9]{4}]}/{month:[0-9]{2}]}/{name}")
    public ResponseEntity<?> download(
            @PathVariable("year") int year,
            @PathVariable("month") int month,
            @PathVariable("name") String name) {
        return service.download(year, month, name);
    }

}
