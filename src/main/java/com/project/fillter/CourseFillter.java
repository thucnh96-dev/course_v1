package com.project.fillter;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Log4j2
public class CourseFillter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        log.debug("Request URI is : " + request.getRequestURI());
        log.debug("Requested Session Id : " + request.getRequestedSessionId());
        log.debug("Requested ParameterMap : " + request.getParameterMap());

        filterChain.doFilter(request, response);
    }

}
