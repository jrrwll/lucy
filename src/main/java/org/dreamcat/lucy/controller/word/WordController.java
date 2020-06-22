package org.dreamcat.lucy.controller.word;

import lombok.RequiredArgsConstructor;
import org.dreamcat.lucy.config.AppConfig;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by tuke on 2020/5/13
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(path = AppConfig.API_VERSION + "/word", method = RequestMethod.POST)
public class WordController {

    /**
     * <pre>
     * @api {post} /count Count words for text
     * @apiDescription Count words for text
     * @apiName CountWord
     * @apiGroup Word
     * @apiParam {string} url which wanna shortened
     * @apiParam {number} [ttl] time-to-live seconds, default value is 604800 (7 days)
     * @apiParam {string} [password] set a password, so that it you must pass the password before visit the target shorten url
     * @apiParam {string} [token] use user token to invoke this API unlimitedly
     * </pre>
     */
    @RequestMapping(path = AppConfig.API_VERSION + "/count", method = RequestMethod.POST)
    public String count() {
        return null;
    }
}
