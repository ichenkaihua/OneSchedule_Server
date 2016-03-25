package com.github.ichenkaihua.oneschedule.security;

import com.github.ichenkaihua.oneschedule.Contants;
import com.github.ichenkaihua.oneschedule.entity.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.web.filter.authz.HttpMethodPermissionFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NoSesstionHttpMethodPermissionFilter extends
        HttpMethodPermissionFilter {

    private static Logger logger = LoggerFactory
            .getLogger(NoSesstionHttpMethodPermissionFilter.class);

    /**
     * 当访问被拒绝时，调用这个方法，这里返回401状态码
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request,
                                     ServletResponse response) throws IOException {
        HttpServletResponse res = (HttpServletResponse) response;
        res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return false;
    }


    @Override
    public boolean isAccessAllowed(ServletRequest request,
                                   ServletResponse response, Object mappedValue) throws IOException {

        HttpServletRequest req = (HttpServletRequest) request;

        String authentication = req.getHeader("Authentication");
        if (authentication != null) {
            MyToken myToken = new MyToken();
            myToken.setTokenValue(authentication);
            try {
                getSubject(request, response).login(myToken);
                // 如果认证成功，则增加request的属性，用于@CurrentUser注解使用
                User user = myToken.getUser();
                request.setAttribute(Contants.CURRENT_USER, user);
            } catch (AuthenticationException e) {
                logger.info("认证失败! " + e.getClass().getSimpleName());
            } catch (Exception e) {
                logger.info("其他认证失败! " + e.getClass().getSimpleName());
                e.printStackTrace();
            }


        }

        boolean result = super.isAccessAllowed(request, response, mappedValue);
        logger.info("restult:" + result);
        return result;
    }

}
