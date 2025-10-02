package org.dreamcat.lucy.controller.doc;

import lombok.RequiredArgsConstructor;
import org.dreamcat.lucy.config.AppConfig;
import org.dreamcat.rita.annotation.Route;
import org.dreamcat.rita.http.RequestMethod;

/**
 * Create by tuke on 2020/6/12
 */
@RequiredArgsConstructor
@Route(path = AppConfig.API_VERSION + "/doc/conv", method = RequestMethod.POST)
public class DocConvController {
}
