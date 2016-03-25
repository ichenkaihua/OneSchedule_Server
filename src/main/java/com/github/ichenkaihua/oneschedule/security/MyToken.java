package com.github.ichenkaihua.oneschedule.security;

import com.github.ichenkaihua.oneschedule.entity.User;
import org.apache.shiro.authc.AuthenticationToken;

/**
 * Created by ChenKH on 2016/3/22.
 */
public class MyToken implements AuthenticationToken {


    private User user;

    public String getTokenValue() {
        return tokenValue;
    }

    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }

    private String tokenValue;





    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return tokenValue;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
