package com.example.demo.utils;

import com.example.demo.common.CheckResult;
import com.example.demo.constant.SystemConstant;
import io.jsonwebtoken.*;
import org.bouncycastle.util.encoders.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SignatureException;
import java.util.Date;

/**
 * 前端发送认证请求   比如用户名密码   认证通过后  后台生成一个 token
 * 发送给前端  前端存储到 localstorage    以后每次请求 都带这个token  发送到后台 去验证
 *
 *
 *
 * @date 2021/5/9 20:44
 */
public class JwtUtils {

    /**
     * 签发JWT
     * @param id
     * @param subject 可以是JSON数据 尽可能少
     * @param ttlMillis
     * @return
     */
    public static String createJWT(String id, String subject, long ttlMillis) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        SecretKey secretKey = generalKey();
        JwtBuilder builder = Jwts.builder()
                .setId(id)
                .setSubject(subject)   // 主体  一般是用户名
                .setIssuer("glls")     // 签发者
                .setIssuedAt(now)      // 签发时间
                .signWith(signatureAlgorithm, secretKey); // 签名算法以及密匙
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;  // 当前时间  + 有效时间
            Date expDate = new Date(expMillis);   // 过期时间
            builder.setExpiration(expDate); // 设置过期时间
        }
        return builder.compact();
    }

    /**
     * 验证JWT
     * @param jwtStr
     * @return
     */
    public static CheckResult validateJWT(String jwtStr) {
        CheckResult checkResult = new CheckResult();
        Claims claims = null;
        try {
            claims = parseJWT(jwtStr);
            checkResult.setSuccess(true);
            checkResult.setClaims(claims);
        } catch (ExpiredJwtException e) {
            checkResult.setErrCode(SystemConstant.JWT_ERRCODE_EXPIRE);
            checkResult.setSuccess(false);
        } catch (SignatureException e) {
            checkResult.setErrCode(SystemConstant.JWT_ERRCODE_FAIL);
            checkResult.setSuccess(false);
        } catch (Exception e) {
            checkResult.setErrCode(SystemConstant.JWT_ERRCODE_FAIL);
            checkResult.setSuccess(false);
        }
        return checkResult;
    }

    /**
     * 生成加密Key
     * @return
     */
    public static SecretKey generalKey() {
        byte[] encodedKey = Base64.decode(SystemConstant.JWT_SECERT);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }


    /**
     * 解析JWT字符串
     * @param jwt
     * @return
     * @throws Exception
     */
    public static Claims parseJWT(String jwt) throws Exception {
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();
    }

    public static void main(String[] args) throws InterruptedException {
         // 后端生成token
        String sc=createJWT("1","jack",SystemConstant.JWT_TTL);
        System.out.println(sc);

        // 后端验证token
        CheckResult checkResult = validateJWT(sc);
        System.out.println(checkResult.isSuccess());
        System.out.println(checkResult.getErrCode());
        Claims claims=checkResult.getClaims();
        System.out.println(claims);
        System.out.println(claims.getId());
        System.out.println(claims.getSubject());

        // 刷新token 重新生成token
        Claims claims2=validateJWT(sc).getClaims();
        String sc2=createJWT(claims2.getId(),claims2.getSubject(),SystemConstant.JWT_TTL);
        System.out.println(sc2);
    }

}
//eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxIiwic3ViIjoiamFjayIsImlzcyI6ImdsbHMiLCJpYXQiOjE2NjA1Mjg2NzgsImV4cCI6MTY2MDUzMjI3OH0.qHUoDo6-BdNmHMzyLFZ-nlUD98te0QU7eenVJGsEiKo