package org.smart4j.framework;

import org.smart4j.framework.helper.ConfigHelper;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DispatcherServlet extends HttpServlet{

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        //初始化Helper相关的类
        HelperLoader.init();
        //获取ServletContext对象
        ServletContext setvletServlet = servletConfig.getServletContext();
        ServletRegistration jspservlet = setvletServlet.getServletRegistration("jsp");
        jspservlet.addMapping(ConfigHelper.getAppJspPath());
        //注册处理静态资源的默认Servlet
        ServletRegistration defaultServlet = setvletServlet.getServletRegistration("default");
        defaultServlet.addMapping(ConfigHelper.getAppAssetPath()+"*");

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
}
