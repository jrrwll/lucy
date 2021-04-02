package org.dreamcat.lucy.controller.imgurl;

import lombok.RequiredArgsConstructor;
import org.dreamcat.lucy.config.AppConfig;
import org.dreamcat.lucy.service.ImageUrlService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Create by tuke on 2021/1/7
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(path = AppConfig.API_VERSION + "/imgurl", method = RequestMethod.POST)
public class ImageUrlController {

    private final ImageUrlService service;

    @RequestMapping(path = "/upload")
    public void upload(
            @RequestPart(name = "file") MultipartFile file,
            @RequestParam(name = "token", required = false) String token) {
        service.upload(file, token);
    }

}
