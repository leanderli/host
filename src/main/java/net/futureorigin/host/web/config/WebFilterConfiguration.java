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
        registrationBean.addUrlPatterns("/host/*");
        registrationBean.setName("authFilter");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<ExceptionFilter> exceptionFilterRegistrationBean() {
        FilterRegistrationBean<ExceptionFilter> registrationBean = new FilterRegistrationBean<>(exceptionFilter);
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("exceptionFilter");
        registrationBean.setOrder(-1);
        return registrationBean;
    }
}