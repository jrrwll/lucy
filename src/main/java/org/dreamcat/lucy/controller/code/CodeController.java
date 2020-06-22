package org.dreamcat.lucy.controller.code;

import lombok.RequiredArgsConstructor;
import org.dreamcat.lucy.config.AppConfig;
import org.dreamcat.lucy.service.CodeService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by tuke on 2020/6/12
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(path = AppConfig.API_VERSION + "/code", method = RequestMethod.POST)
public class CodeController {
    private final CodeService service;

    @RequestMapping(path = "/format")
    public String format(
            @RequestParam(required = false, defaultValue = "hex") String style,
            @RequestBody String code) {
        return service.format(code, style);
    }

    @RequestMapping(path = "/compact")
    public String compact(@RequestBody String code) {
        return service.compact(code);
    }
}
