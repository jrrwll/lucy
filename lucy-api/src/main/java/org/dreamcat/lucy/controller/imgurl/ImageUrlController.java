package org.dreamcat.lucy.controller.imgurl;

import lombok.RequiredArgsConstructor;
import org.dreamcat.lucy.config.AppConfig;
import org.dreamcat.lucy.service.ImageUrlService;
import org.dreamcat.rita.annotation.RequestParam;
import org.dreamcat.rita.annotation.RequestPart;
import org.dreamcat.rita.annotation.Route;
import org.dreamcat.rita.http.RequestMethod;
import org.dreamcat.rita.web.MultipartFile;

/**
 * Create by tuke on 2021/1/7
 */
@RequiredArgsConstructor
@Route(path = AppConfig.API_VERSION + "/imgurl", method = RequestMethod.POST)
public class ImageUrlController {

    private final ImageUrlService service;

    @Route(path = "/upload")
    public void upload(
            @RequestPart(value = "file") MultipartFile file,
            @RequestParam(required = false) String token) {
        service.upload(file, token);
    }

}
