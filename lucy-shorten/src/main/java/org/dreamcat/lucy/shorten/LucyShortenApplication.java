package org.dreamcat.lucy.shorten;

import org.dreamcat.common.web.exception.ForbiddenException;
import org.dreamcat.rita.annotation.Injected;
import org.dreamcat.rita.annotation.PathVariable;
import org.dreamcat.rita.annotation.RequestParam;
import org.dreamcat.rita.annotation.RitaBootApplication;
import org.dreamcat.rita.annotation.Route;
import org.dreamcat.rita.boot.RitaApplication;
import org.dreamcat.rita.renderer.HttpHeaders;
import org.dreamcat.rita.renderer.ResponseEntity;
import org.dreamcat.rita.renderer.ResponseEntity.ResponseEntityBuilder;

/**
 * Create by tuke on 2020/6/2
 */
@Route
@RitaBootApplication
public class LucyShortenApplication {
    public static void main(String[] args) {
        RitaApplication.run(LucyShortenApplication.class, args);
    }

    @Injected
    private LucyShortenService service;

    /**
     * @api {get} /:hash, shorten url, like `http(s)://deampoor.com/xxx`
     * @apiParam hash, [a-zA-Z0-9]{3,12} case sensitive, 62^6 56800235584 ~= 5.6E10,
     */
    @Route(path = "/{hash:[0-9a-zA-Z]{6,}}")
    public ResponseEntity<?> route(
            @PathVariable String hash,
            @RequestParam(required = false) String password) {
        String location;
        ResponseEntityBuilder<?> builder;
        try {
            location = service.getLocation(hash, password);
            if (location == null) {
                builder = ResponseEntity.notFound();
            } else {
                builder = ResponseEntity.found();
                builder.header(HttpHeaders.LOCATION.get(), location);
            }
        } catch (ForbiddenException e) {
            builder = ResponseEntity.forbidden();
        }
        return builder.build();
    }
}
