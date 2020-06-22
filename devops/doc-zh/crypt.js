/**
 * <pre>
 * @api {post} /crypt/encrypt 加密一段明文
 * @apiDescription 加密一段明文
 * @apiName Encrypt
 * @apiGroup Crypto
 * @apiParam {string} algorithm 加解密算法，
 *      取值其中之一：aes, des, desede(or tripledes), rabbit, rc2, rc4
 * @apiParam {string} key 密码
 * @apiParam {string} text, 将被加密的明文，作为请求体字符串
 * @apiSuccessExample {text} 调用成功的响应示例:
 * `base64`编码的加密后的密文，作为响应体字符串
 * @apiErrorExample {json} 调用失败的响应示例:
 * {
 *     "code": -1,
 *     "success": false,
 *     "msg": "encrypt failed"
 * }
 * @apiError (Error 400 code = -1) code 不支持的算法
 * @apiError (Error 500 code = -1) code 加密失败
 * </pre>
 */

/**
 * <pre>
 * @api {post} /crypt/decrypt 解密一段密文
 * @apiDescription 解密一段密文
 * @apiName Decrypt
 * @apiGroup Crypto
 * @apiParam {string} algorithm 加解密算法，
 *      取值其中之一：aes, des, desede(or tripledes), rabbit, rc2, rc4
 * @apiParam {string} key 密码
 * @apiParam {string} text, 将被解密的密文，作为请求体字符串
 * @apiSuccessExample {text} 调用成功的响应示例:
 * `base64`编码的解密后的明文，作为响应体字符串
 * @apiErrorExample {json} 调用失败的响应示例:
 * {
 *     "code": -1,
 *     "success": false,
 *     "msg": "decrypt failed"
 * }
 * @apiError (Error 400 code = -1) code 不支持的算法，或解密失败
 * </pre>
 */

/**
 * <pre>
 * @api {post} /crypt/sign 签名摘要
 * @apiDescription 对一段明文进行签名摘要
 * @apiName Sign
 * @apiGroup Crypto
 * @apiParam {string} algorithm 签名摘要算法,
 *      取值其中之一：md5, hs1(or hmacsha1), hs256(or hmacsha256), hs512(or hmacsha512), hm5(or hmacmd5)
 * @apiParam {string} key 签名摘要密码, 只有 'hmac*' 算法需要传入此参数
 * @apiParam {string} format 摘要格式，取值其中之一：hex十六进制, base64, 默认值为hex
 * @apiParam {string} text, 将被签名的明文，作为请求体字符串
 * @apiSuccessExample {text} 调用成功的响应示例:
 * 指定格式编码的摘要，作为响应体字符串
 * @apiErrorExample {json} 调用失败的响应示例:
 * {
 *     "code": -1,
 *     "success": false,
 *     "msg": "sign failed"
 * }
 * @apiError (Error 400 code = -1) code 不支持的算法，或格式
 * @apiError (Error 500 code = -1) code 加密失败
 * </pre>
 */
