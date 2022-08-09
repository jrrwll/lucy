package org.dreamcat.lucy.service.impl;

import java.io.IOException;
import java.util.regex.Pattern;
import lombok.extern.slf4j.Slf4j;
import org.dreamcat.common.crypto.CryptUtil;
import org.dreamcat.common.crypto.RC4Util;
import org.dreamcat.common.crypto.RabbitUtil;
import org.dreamcat.common.crypto.SignUtil;
import org.dreamcat.common.util.Base64Util;
import org.dreamcat.common.util.ByteUtil;
import org.dreamcat.common.web.exception.BadRequestException;
import org.dreamcat.common.web.exception.InternalServerErrorException;
import org.dreamcat.lucy.service.CryptService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Create by tuke on 2020/5/13
 */
@Slf4j
@Service
public class CryptServiceImpl implements CryptService {
    private static final Pattern encrypt_algorithm = Pattern.compile(
            "aes|des|tripledes|3des|rc4|rabbit", Pattern.CASE_INSENSITIVE);

    @Override
    public String encrypt(String text, String algorithm, String key) {
        algorithm = algorithm.toLowerCase();
        try {
            return switch (algorithm) {
                case "aes" -> CryptUtil.encryptAesAsBase64(text, key);
                case "des" -> CryptUtil.encryptDesAsBase64(text, key);
                case "tripledes", "desede" -> CryptUtil.encrypt3DesAsBase64(text, key);
                case "rc2" -> CryptUtil.encryptRc2AsBase64(text, key);
                case "rc4" -> RC4Util.encryptAsBase64(text, key);
                case "rabbit" -> RabbitUtil.encryptAsBase64(text, key);
                default -> throw new BadRequestException("unsupported algorithm " + algorithm);
            };
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new InternalServerErrorException("encrypt failed");
        }
    }

    @Override
    public String decrypt(String text, String algorithm, String key) {
        algorithm = algorithm.toLowerCase();
        try {
            return switch (algorithm) {
                case "aes" -> CryptUtil.decryptAesFromBase64(text, key);
                case "des" -> CryptUtil.decryptDesFromBase64(text, key);
                case "tripledes", "desede" -> CryptUtil.decrypt3DesFromBase64(text, key);
                case "rc2" -> CryptUtil.decryptRc2FromBase64(text, key);
                case "rc4" -> RC4Util.decryptFromBase64(text, key);
                case "rabbit" -> RabbitUtil.decryptFromBase64(text, key);
                default -> throw new BadRequestException("unsupported algorithm " + algorithm);
            };
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BadRequestException("decrypt failed");
        }
    }

    @Override
    public String sign(String text, String algorithm, String key, String format) {
        algorithm = algorithm.toLowerCase();

        byte[] sign;
        if (algorithm.equals("md5")) {
            sign = SignUtil.md5(text);
        } else {
            try {
                sign = switch (algorithm) {
                    case "hs1", "hmacsha1" -> SignUtil.hs1(text, key);
                    case "hs256", "hmacsha256" -> SignUtil.hs256(text, key);
                    case "hs512", "hmacsha512" -> SignUtil.hs512(text, key);
                    case "hm5", "hmacmd5" -> SignUtil.hm5(text, key);
                    default -> throw new BadRequestException("unsupported algorithm " + algorithm);
                };
            } catch (Exception e) {
                log.error(e.getMessage());
                throw new InternalServerErrorException("sign failed");
            }
        }

        return switch (format) {
            case "hex" -> ByteUtil.hex(sign);
            case "base64" -> Base64Util.encodeAsString(sign);
            default -> throw new BadRequestException("unsupported format " + format);
        };
    }

    @Override
    public String signFile(MultipartFile file, String algorithm, String key, String format) {
        algorithm = algorithm.toLowerCase();

        byte[] sign;
        try (var input = file.getInputStream()) {
            if (algorithm.equals("md5")) {
                sign = SignUtil.md5(input);
            } else {
                try {
                    sign = switch (algorithm) {
                        case "hs1", "hmacsha1" -> SignUtil.hs1(input, key);
                        case "hs256", "hmacsha256" -> SignUtil.hs256(input, key);
                        case "hs512", "hmacsha512" -> SignUtil.hs512(input, key);
                        case "hm5", "hmacmd5" -> SignUtil.hm5(input, key);
                        default -> throw new BadRequestException("unsupported algorithm " + algorithm);
                    };
                } catch (Exception e) {
                    log.error(e.getMessage());
                    throw new InternalServerErrorException("sign failed");
                }
            }
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new InternalServerErrorException("I/O error");
        }

        return switch (format) {
            case "hex" -> ByteUtil.hex(sign);
            case "base64" -> Base64Util.encodeAsString(sign);
            default -> throw new BadRequestException("unsupported format " + format);
        };
    }

}
