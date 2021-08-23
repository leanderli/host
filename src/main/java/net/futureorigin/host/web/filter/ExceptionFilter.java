package net.futureorigin.host.web.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Objects;

@Component
public class ExceptionFilter implements Filter {
    private final static String REQ_EXCEPTION = "filterException";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        boolean isRethrow = !Objects.isNull(request.getAttribute(REQ_EXCEPTION));
        if (isRethrow) {
            chain.doFilter(request, response);
            return;
        }
        try {
            chain.doFilter(request, response);
        } catch (Exception e) {
            // 异常捕获，发送到 FilterExceptionController
            request.setAttribute(REQ_EXCEPTION, e);
            //将异常分发到 /exception/filterException 控制器
            request.getRequestDispatcher("/exception/handleFilterException").forward(request, response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void destroy() {

    }

    @RestController
    @RequestMapping(path = "exception")
    public static class FilterExceptionController {

        @RequestMapping(path = "handleFilterException")
        public void handleFilterException(HttpServletRequest request) throws Exception {
            throw (Exception) request.getAttribute(REQ_EXCEPTION);
        }
    }
}