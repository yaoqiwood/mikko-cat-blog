package com.summer.cat.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author summer
 * @since 2018-05-03
 */
public class JWTToken implements AuthenticationToken {

    // 密钥
    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
