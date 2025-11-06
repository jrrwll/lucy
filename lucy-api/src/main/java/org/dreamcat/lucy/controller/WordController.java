package org.dreamcat.lucy.controller;

import lombok.RequiredArgsConstructor;
import org.dreamcat.lucy.common.config.AppConfig;
import org.dreamcat.rita.annotation.Route;
import org.dreamcat.rita.http.RequestMethod;

/**
 * Create by tuke on 2020/5/13
 */
@RequiredArgsConstructor
@Route(path = "/word", method = RequestMethod.POST)
public class WordController {

    // count words for text
    @Route(path = "/count", method = RequestMethod.POST)
    public String count() {
        return null;
    }

    @Route(path = "/chs2cht", method = RequestMethod.POST)
    public String chs2cht() {
        return null;
    }

    @Route(path = "/pinyin", method = RequestMethod.POST)
    public String pinyin() {
        return null;
    }

    // 农历 to 公历
    @Route(path = "/lunar2gregorian", method = RequestMethod.POST)
    public String lunar2gregorian() {
        return null;
    }
}
