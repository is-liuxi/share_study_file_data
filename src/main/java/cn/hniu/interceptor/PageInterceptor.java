package cn.hniu.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 拦截器，当没有登录时访问管理员界面，跳转到登录页面
 */
@Component
public class PageInterceptor extends HandlerInterceptorAdapter {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("拦截器执行 ====> ");

        HttpSession session = request.getSession();

        Object admin = session.getAttribute("admin");

        String contextPath = session.getServletContext().getContextPath();
        logger.info("项目路径" + contextPath);
        if (admin == null) {
            response.sendRedirect(contextPath + "/index");
        }
        return true;
    }
}
