package org.dreamcat.lucy.controller;

import lombok.RequiredArgsConstructor;
import org.dreamcat.rita.annotation.Route;
import org.dreamcat.rita.http.RequestMethod;

/**
 * Create by tuke on 2020/6/12
 */
@RequiredArgsConstructor
@Route(path = "/image", method = RequestMethod.POST)
public class ImageController {

    @Route(path = "/q2code")
    public String count() {
        return null;
    }

    @Route(path = "/banner")
    public String banner() {
        return null;
    }
}
