package org.dreamcat.lucy.controller.shorten;

import lombok.RequiredArgsConstructor;
import org.dreamcat.lucy.config.AppConfig;
import org.dreamcat.lucy.service.ShortenService;
import org.dreamcat.rita.annotation.RequestParam;
import org.dreamcat.rita.annotation.Route;
import org.dreamcat.rita.http.RequestMethod;

/**
 * Create by tuke on 2020/5/13
 */
@RequiredArgsConstructor
@Route
public class ShortenController {
    private final ShortenService service;

    /**
     * <pre>
     * @api {post} /shorten Shorten some urls
     * @apiDescription Shorten some urls
     * @apiName Shorten
     * @apiGroup Shorten
     * @apiParam {string} url which wanna shortened
     * @apiParam {number} [ttl] time-to-live seconds, default value is 604800 (7 days)
     * @apiParam {string} [password] set a password, so that it you must pass the password before visit the target shorten url
     * @apiParam {string} [token] use a user token to invoke this API limitlessly
     * </pre>
     */
    @Route(path = AppConfig.API_VERSION + "/shorten", method = RequestMethod.POST)
    public String shorten(
            @RequestParam String url,
            // default is 7 days, 7 * 24 * 3600
            @RequestParam(defaultValue = "604800") int ttl,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String token) {
        return service.shorten(url, ttl, password, token);
    }

}
