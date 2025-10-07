package org.dreamcat.lucy.helper;

import org.dreamcat.common.Pair;
import org.dreamcat.common.codec.Base64Util;
import org.dreamcat.common.crypto.SignUtil;
import org.dreamcat.common.snowflake.IdWorker;
import org.dreamcat.common.util.StringUtil;
import org.dreamcat.rita.annotation.Provider;

import java.math.BigInteger;

/**
 * @author Jerry Will
 * @version 2025-10-07
 */
@Provider
public class ShortenCodeGenerateHelper {

    // todo injected
    IdWorker idWorker = new IdWorker(0);

    public String generateCode() {
        long id = idWorker.nextId();
        return StringUtil.mappingTo62(id);
    }

    public Pair<String, String> generateMd5AndCode(String url) {
        byte[] digest = SignUtil.md5(url);
        BigInteger n = new BigInteger(digest);

        String base64 = Base64Util.encodeAsString(digest);
        String code = StringUtil.mappingTo62(n);
        return Pair.of(base64, code);
    }
}
