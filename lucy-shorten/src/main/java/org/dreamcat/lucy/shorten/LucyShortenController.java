package org.dreamcat.lucy.shorten;

import lombok.RequiredArgsConstructor;
import org.dreamcat.common.web.exception.ForbiddenException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by tuke on 2020/6/2
 */
@RequiredArgsConstructor
@RestController
public class LucyShortenController {
    private final LucyShortenService service;

    /**
     * @api {get} /:hash, shorten url, like `http(s)://deampoor.com/xxx`
     * @apiParam hash, [a-zA-Z0-9]{3,12} case sensitive, 62^6 56800235584 ~= 5.6E10,
     */
    @RequestMapping(path = "/{hash:[0-9a-zA-Z]{6,}}")
    public ResponseEntity<?> route(
            @PathVariable(name = "hash") String hash,
            @RequestParam(name = "password", required = false) String password) {
        String location;
        ResponseEntity.BodyBuilder builder;
        try {
            location = service.getLocation(hash, password);
            if (location == null) {
                builder = ResponseEntity.status(HttpStatus.NOT_FOUND);
            } else {
                builder = ResponseEntity.status(HttpStatus.FOUND);
                builder.header(HttpHeaders.LOCATION, location);
            }
        } catch (ForbiddenException e) {
            builder = ResponseEntity.status(HttpStatus.FORBIDDEN);
        }
        return builder.build();
    }

}
