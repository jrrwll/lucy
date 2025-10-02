package org.dreamcat.lucy.controller.word;

import lombok.RequiredArgsConstructor;
import org.dreamcat.lucy.config.AppConfig;
import org.dreamcat.rita.annotation.Route;
import org.dreamcat.rita.http.RequestMethod;

/**
 * Create by tuke on 2020/6/12
 */
@RequiredArgsConstructor
@Route(path = AppConfig.API_VERSION + "/word/zh", method = RequestMethod.POST)
public class WordZhController {

    @Route(path = AppConfig.API_VERSION + "/chs2cht", method = RequestMethod.POST)
    public String chs2cht() {
        return null;
    }

    @Route(path = AppConfig.API_VERSION + "/pinyin", method = RequestMethod.POST)
    public String pinyin() {
        return null;
    }

    // 农历 to 公历
    @Route(path = AppConfig.API_VERSION + "/lunar2gregorian", method = RequestMethod.POST)
    public String lunar2gregorian() {
        return null;
    }

}
