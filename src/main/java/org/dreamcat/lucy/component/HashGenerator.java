package org.dreamcat.lucy.component;

import org.dreamcat.common.crypto.MD5Util;
import org.dreamcat.common.util.NumericUtil;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Create by tuke on 2020/5/13
 */
@Component
public class HashGenerator {

    private static final char[] TO_62 = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
    };
    private static final BigInteger BI_62 = BigInteger.valueOf(64);
    private static final Map<Integer, BigInteger> POWS = new ConcurrentHashMap<>();

    public String hash(String text, int width) {
        BigInteger bound = POWS.computeIfAbsent(width, BI_62::pow);
        byte[] digest = MD5Util.md5(text);

        long rem = new BigInteger(digest).remainder(bound).longValue();
        int[] digits = NumericUtil.digit(rem, 62);
        int size = digits.length;
        var s = new StringBuilder(size);
        for (int i = size - 1; i >= 0; i--) {
            s.append(TO_62[digits[i]]);
        }
        return s.toString();
    }

}
