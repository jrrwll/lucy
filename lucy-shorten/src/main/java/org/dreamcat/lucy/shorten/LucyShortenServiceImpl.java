package org.dreamcat.lucy.shorten;

import lombok.RequiredArgsConstructor;
import org.dreamcat.common.crypto.MD5Util;
import org.dreamcat.common.web.exception.ForbiddenException;
import org.dreamcat.lucy.dao.ShortenUrlDao;
import org.springframework.stereotype.Service;

/**
 * Create by tuke on 2020/6/2
 */
@RequiredArgsConstructor
@Service
public class LucyShortenServiceImpl implements LucyShortenService {
    private final ShortenUrlDao shortenUrlDao;

    @Override
    public String getLocation(String hash, String password) {
        var entity = shortenUrlDao.findById(hash).orElse(null);
        if (entity == null) return null;

        var passwd = entity.getPassword();
        if (passwd != null) {
            boolean forbidden = true;
            if (password != null) {
                if (MD5Util.md5Base64(password).equals(passwd)) {
                    forbidden = false;
                }
            }
            if (forbidden) {
                throw new ForbiddenException("require password");
            }
        }

        return entity.getUrl();
    }

}
