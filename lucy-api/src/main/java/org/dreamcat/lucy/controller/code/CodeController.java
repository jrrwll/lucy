package org.dreamcat.lucy.controller.code;

import lombok.RequiredArgsConstructor;
import org.dreamcat.lucy.service.CodeService;
import org.dreamcat.rita.annotation.RequestBody;
import org.dreamcat.rita.annotation.RequestParam;
import org.dreamcat.rita.annotation.Route;
import org.dreamcat.rita.http.RequestMethod;

/**
 * Create by tuke on 2020/6/12
 */
@RequiredArgsConstructor
@Route(path = "/code", method = RequestMethod.POST)
public class CodeController {
    private final CodeService service;

    @Route(path = "/format")
    public String format(
            @RequestParam(required = false, defaultValue = "hex") String style,
            @RequestBody String code) {
        return service.format(code, style);
    }

    @Route(path = "/compact")
    public String compact(@RequestBody String code) {
        return service.compact(code);
    }
}
