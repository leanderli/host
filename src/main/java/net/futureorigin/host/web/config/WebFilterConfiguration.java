package net.futureorigin.host.web.config;

import net.futureorigin.host.web.filter.AuthFilter;
import net.futureorigin.host.web.filter.ExceptionFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebFilterConfiguration {

    private final AuthFilter authFilter;
    private final ExceptionFilter exceptionFilter;

    public WebFilterConfiguration(ExceptionFilter exceptionFilter,
                                  AuthFilter authFilter) {
        this.exceptionFilter = exceptionFilter;
        this.authFilter = authFilter;
    }

    @Bean
    public FilterRegistrationBean<AuthFilter> FilterRegistrationBean() {
        FilterRegistrationBean<AuthFilter> registrationBean = new FilterRegistrationBean<>(authFilter);
        //过滤所有路径
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("authFilter");
        registrationBean.setOrder(1);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<ExceptionFilter> exceptionFilterRegistrationBean() {
        FilterRegistrationBean<ExceptionFilter> registrationBean = new FilterRegistrationBean<>(exceptionFilter);
        //过滤所有路径auth
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("exceptionFilter");
        registrationBean.setOrder(-1);
        return registrationBean;
    }
}