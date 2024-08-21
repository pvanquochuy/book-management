package com.example.identity_service.configuration;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Slf4j
public class AuthenticationRequestIntereptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes servletRequestAttributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        var authHeader = servletRequestAttributes.getRequest().getHeader("Authorization");
        log.info("AuthHeader: {}", authHeader);

        if(StringUtils.hasText(authHeader)){
            requestTemplate.header("Authorization", authHeader);
        }
    }
}
