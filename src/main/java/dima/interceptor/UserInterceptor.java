package dima.interceptor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

public class UserInterceptor extends HandlerInterceptorAdapter {

    private final static Logger logger = LogManager.getLogger(UserInterceptor.class);

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
        logger.info(response.getStatus());
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Enumeration<String> user = request.getHeaders("user");
        if (user.hasMoreElements()) {
            logger.info(user.nextElement());
        }
        return super.preHandle(request, response, handler);
    }

}
