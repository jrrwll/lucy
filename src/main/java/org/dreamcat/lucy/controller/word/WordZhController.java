package org.dreamcat.lucy.controller.word;

import lombok.RequiredArgsConstructor;
import org.dreamcat.lucy.config.AppConfig;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by tuke on 2020/6/12
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(path = AppConfig.API_VERSION + "/word/zh", method = RequestMethod.POST)
public class WordZhController {

    @RequestMapping(path = AppConfig.API_VERSION + "/chs2cht", method = RequestMethod.POST)
    public String chs2cht() {
        return null;
    }

    @RequestMapping(path = AppConfig.API_VERSION + "/pinyin", method = RequestMethod.POST)
    public String pinyin() {
        return null;
    }

    // 农历 to 公历
    @RequestMapping(path = AppConfig.API_VERSION + "/lunar2gregorian", method = RequestMethod.POST)
    public String lunar2gregorian() {
        return null;
    }

}
