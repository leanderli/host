package net.futureorigin.host.web.filter;

import net.futureorigin.host.common.HostProperties;
import net.futureorigin.host.common.exception.AuthException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import java.io.IOException;
import java.util.Arrays;

/**
 * AuthFilter
 * <p></p>
 *
 * @author Leander Lee on 2021/8/22.
 */
@Component
public class AuthFilter implements Filter {

    private final HostProperties hostProperties;

    public AuthFilter(HostProperties properties) {
        this.hostProperties = properties;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (null == hostProperties.getAllowedAccesskey() || hostProperties.getAllowedAccesskey().length <= 0) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        String accessKey = servletRequest.getParameter("accessKey");
        if (StringUtils.isEmpty(accessKey)) {
            throw new AuthException(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Param 'accessKey' must be not null.");
        }
        if (Arrays.stream(hostProperties.getAllowedAccesskey()).noneMatch(s -> s.equals(accessKey))) {
            throw new AuthException(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Param 'accessKey' is invalid.");
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
