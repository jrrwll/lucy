package org.dreamcat.lucy.controller.network;

import lombok.RequiredArgsConstructor;
import org.dreamcat.lucy.config.AppConfig;
import org.dreamcat.lucy.service.NetworkService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Create by tuke on 2020/6/22
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(path = AppConfig.API_VERSION + "/network", method = RequestMethod.GET)
public class NetworkController {
    private final NetworkService service;

    @RequestMapping(path = "/ip")
    public String detectIP(HttpServletRequest request) {
        return service.detectIP(request);
    }

}
