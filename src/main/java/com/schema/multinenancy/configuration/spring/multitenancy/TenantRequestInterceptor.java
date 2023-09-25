package com.schema.multinenancy.configuration.spring.multitenancy;

import java.util.Optional;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.schema.multinenancy.configuration.multitenancy.context.TenantContext;


public class TenantRequestInterceptor implements AsyncHandlerInterceptor{


    public TenantRequestInterceptor() {
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        return Optional.ofNullable(request)
                .map(tenant -> setTenantContext("public"))
                .orElse(false);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        TenantContext.clear();
    }

    private boolean setTenantContext(String tenant) {
        TenantContext.setCurrentTenant(tenant);
        return true;
    }
}