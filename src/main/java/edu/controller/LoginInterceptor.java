package edu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登陆验证
 *
 * @author wgt
 * @date 17-12-12
 */
public class LoginInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        String url = httpServletRequest.getRequestURI();

        if (url.indexOf("user") >= 0 || url.indexOf("login") >= 0||url.indexOf("layui")>=0) {
            return true;
        }

        HttpSession session = httpServletRequest.getSession();

        Integer userType = (Integer) session.getAttribute("userType");

        if (userType != null && userType != 0) {

            switch (userType) {
                case 1:
                    if (url.indexOf("admin") < 0) {
                        httpServletResponse.sendRedirect("/admin/admin_index.html");
                        return false;
                    }
                    break;
                case 2:
                    if (url.indexOf("teacher") < 0) {
                        httpServletResponse.sendRedirect("/teacher/teacher_index.html");
                        return false;
                    }
                    break;
                case 3:
                    if (url.indexOf("student") < 0) {
                        httpServletResponse.sendRedirect("/student/student_index.html");
                        return false;
                    }
                    break;
                default:
                    httpServletRequest.getRequestDispatcher("/login/login.html").forward(httpServletRequest,httpServletResponse);
                    return false;

            }
            return true;
        } else {
            httpServletResponse.sendRedirect("/login/login.html");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
