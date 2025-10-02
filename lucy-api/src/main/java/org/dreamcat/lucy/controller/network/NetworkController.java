package org.dreamcat.lucy.controller.network;

import lombok.RequiredArgsConstructor;
import org.dreamcat.lucy.config.AppConfig;
import org.dreamcat.lucy.service.NetworkService;
import org.dreamcat.rita.annotation.Route;
import org.dreamcat.rita.http.Request;
import org.dreamcat.rita.http.RequestMethod;

/**
 * Create by tuke on 2020/6/22
 */
@RequiredArgsConstructor
@Route(path = AppConfig.API_VERSION + "/network", method = RequestMethod.GET)
public class NetworkController {
    private final NetworkService service;

    @Route(path = "/ip")
    public String detectIP(Request request) {
        return service.detectIP(request);
    }

}
