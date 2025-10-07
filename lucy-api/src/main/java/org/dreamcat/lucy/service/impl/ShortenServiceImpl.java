package org.dreamcat.lucy.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dreamcat.common.Pair;
import org.dreamcat.common.crypto.SignUtil;
import org.dreamcat.common.web.exception.UnauthorizedException;
import org.dreamcat.lucy.cache.CacheRepository;
import org.dreamcat.lucy.config.AppProperties;
import org.dreamcat.lucy.dao.AccountDao;
import org.dreamcat.lucy.dao.ShortenUrlDao;
import org.dreamcat.lucy.entity.ShortenUrl;
import org.dreamcat.lucy.helper.ShortenCodeGenerateHelper;
import org.dreamcat.lucy.service.ShortenService;
import org.dreamcat.rita.annotation.Provider;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * Create by tuke on 2020/5/13
 */
@Slf4j
@RequiredArgsConstructor
@Provider
public class ShortenServiceImpl implements ShortenService {

    private final AccountDao accountDao;
    private final ShortenUrlDao shortenUrlDao;
    private final AppProperties properties;
    private final CacheRepository cacheRepository;
    private final ShortenCodeGenerateHelper shortenCodeGenerateHelper;

    @Override
    public String shorten(String url, int ttl, String password, String token) {
        boolean unauthorized = false;
        if (ttl > properties.getShorten().getUnauthorizedMaxTtl()) {
            if (token == null) {
                unauthorized = true;
            } else {
                var account = accountDao.findByToken(token);
                if (account == null) unauthorized = true;
            }
        }
        if (unauthorized) {
            throw new UnauthorizedException("require token");
        }
        url = URLDecoder.decode(url, StandardCharsets.UTF_8);

        Pair<String, String> pair = shortenCodeGenerateHelper.generateMd5AndCode(url);
        String md5 = pair.first();
        String code = pair.second();

        var cachedCode = cacheRepository.getShortenUrl(md5);
        // Note that repeat url, just return the existing hash
        if (cachedCode != null) {
            return cachedCode;
        }

        var entity = new ShortenUrl();
        entity.setUrl(url);
        entity.setHash(code);
        if (password != null) {
            entity.setPassword(SignUtil.md5Base64(password));
        }
        if (ttl > 0) {
            long expiredAt = System.currentTimeMillis() + ttl * 1000L;
            entity.setExpiredAt(new Date(expiredAt));
        }
        shortenUrlDao.insert(entity);
        return code;
    }

}
