package org.dreamcat.lucy.controller.image;

import lombok.RequiredArgsConstructor;
import org.dreamcat.lucy.config.AppConfig;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by tuke on 2020/6/12
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(path = AppConfig.API_VERSION + "/image", method = RequestMethod.POST)
public class ImageController {

    @RequestMapping(path = "/q2code")
    public String count() {
        return null;
    }

    @RequestMapping(path = "/banner")
    public String banner() {
        return null;
    }
}
