package org.smart4j.framework.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloShiro {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloShiro.class);

    public static void main(String[] args) {
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManger = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManger);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("shiro", "1234056");
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            LOGGER.info("登录失败");
            e.printStackTrace();
            return;
        }
        LOGGER.info("登录成功");
        subject.logout();
    }
}
