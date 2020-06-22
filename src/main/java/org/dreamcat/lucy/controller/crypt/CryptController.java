package org.dreamcat.lucy.controller.crypt;

import lombok.RequiredArgsConstructor;
import org.dreamcat.lucy.config.AppConfig;
import org.dreamcat.lucy.service.CryptService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Create by tuke on 2020/5/13
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(path = AppConfig.API_VERSION + "/crypt", method = RequestMethod.POST)
public class CryptController {
    private final CryptService service;

    /**
     * <pre>
     * @api {post} /crypt/encrypt Encrypt some text
     * @apiDescription Encrypt some text
     * @apiName Encrypt
     * @apiGroup Crypto
     * @apiParam {string} algorithm crypto algorithm,
     *      one of aes, des, desede(or tripledes), rabbit, rc2, rc4
     * @apiParam {string} key password to encrypt data
     * @apiParam {string} text, which will be encrypted, pass by `request body`
     * @apiSuccessExample {string} Success-Response:
     * base64 encoded encrypted text
     * @apiErrorExample {json} Error-Response:
     * {
     *     "code": -1,
     *     "success": false,
     *     "msg": "encrypt failed"
     * }
     * @apiError (Error 400 code = -1) code unsupported algorithm
     * @apiError (Error 500 code = -1) code encrypt failed
     * </pre>
     */
    @RequestMapping(path = "/encrypt")
    public String encrypt(
            @RequestParam String algorithm,
            @RequestParam String key,
            @RequestBody String text) {
        return service.encrypt(text, algorithm, key);
    }

    /**
     * <pre>
     * @api {post} /crypt/decrypt Decrypt some text
     * @apiDescription Decrypt some text
     * @apiName Decrypt
     * @apiGroup Crypto
     * @apiParam {string} algorithm crypto algorithm,
     *      one of aes, des, desede(or tripledes), rabbit, rc2, rc4
     * @apiParam {string} key password to decrypt data
     * @apiParam {string} text, which will be decrypted, pass by `request body`
     * @apiSuccessExample {string} Success-Response:
     * base64 encoded decrypted text
     * @apiErrorExample {json} Error-Response:
     * {
     *     "code": -1,
     *     "success": false,
     *     "msg": "decrypt failed"
     * }
     * @apiError (Error 400 code = -1) code unsupported algorithm, or decrypt failed
     * </pre>
     */
    @RequestMapping(path = "/decrypt")
    public String decrypt(
            @RequestParam String algorithm,
            @RequestParam String key,
            @RequestBody String text) {
        return service.decrypt(text, algorithm, key);
    }

    /**
     * <pre>
     * @api {post} /crypt/sign Sign some text
     * @apiDescription Sign some text
     * @apiName Sign
     * @apiGroup Crypto
     * @apiParam {string} algorithm sign algorithm,
     *      one of md5, hs1(or hmacsha1), hs256(or hmacsha256), hs512(or hmacsha512), hm5(or hmacmd5)
     * @apiParam {string} key password to sign data, only required by 'hmac*' algorithm
     * @apiParam {string} format one of hex, base64, default value is hex
     * @apiParam {string} text, which will be signed, pass by `request body`
     * @apiSuccessExample {string} Success-Response:
     * sign digest in 'format' format
     * @apiErrorExample {json} Error-Response:
     * {
     *     "code": -1,
     *     "success": false,
     *     "msg": "sign failed"
     * }
     * @apiError (Error 400 code = -1) code unsupported algorithm or format
     * @apiError (Error 500 code = -1) code sign failed
     * </pre>
     */
    @RequestMapping(path = "/sign")
    public String sign(
            @RequestParam String algorithm,
            @RequestParam(name = "key", required = false) String key,
            @RequestParam(name = "format", required = false, defaultValue = "hex") String format,
            @RequestBody String text) {
        return service.sign(text, algorithm, key, format);
    }

    /**
     * <pre>
     * @api {post} /crypt/sign/file Sign a file
     * @apiDescription Sign a file
     * @apiName SignFile
     * @apiGroup Crypto
     * @apiParam {string} algorithm sign algorithm,
     *      one of md5, hs1(or hmacsha1), hs256(or hmacsha256), hs512(or hmacsha512), hm5(or hmacmd5)
     * @apiParam {string} key password to sign data, only required by 'hmac*' algorithm
     * @apiParam {string} format one of hex, base64, default value is hex
     * @apiParam {File} file, which will be signed, pass by `multipart/form-data`
     * @apiSuccessExample {string} Success-Response:
     * sign digest in 'format' format
     * @apiErrorExample {json} Error-Response:
     * {
     *     "code": -1,
     *     "success": false,
     *     "msg": "sign failed"
     * }
     * @apiError (Error 400 code = -1) code unsupported algorithm or format
     * @apiError (Error 500 code = -1) code sign failed
     * </pre>
     */
    @RequestMapping(path = "/sign/file")
    public String signFile(
            @RequestParam String algorithm,
            @RequestParam(name = "key", required = false) String key,
            @RequestParam(name = "format", required = false, defaultValue = "hex") String format,
            @RequestPart MultipartFile file) {
        return service.signFile(file, algorithm, key, format);
    }

}
