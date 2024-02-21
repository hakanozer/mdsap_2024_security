package com.works.configs;

import com.works.entities.Customer;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class FilterConfig implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String url = req.getRequestURI();
        String[] freeUrls = { "/", "/login", "/signup", "/customerLogin" };
        boolean loginStatus = true;
        for ( String item : freeUrls ) {
            if (item.equals(url)) {
                loginStatus = false;
                break;
            }
        }

        if (loginStatus) {
            boolean status = req.getSession().getAttribute("customer") == null;
            if (status) {
                res.sendRedirect("/login");
            }else {
                // login success
                Customer customer = (Customer) req.getSession().getAttribute("customer");
                req.setAttribute("customer", customer);
                filterChain.doFilter(req, res);
            }
        }else {
            filterChain.doFilter(req, res);
        }

        String agent = req.getHeader("User-Agent");
        String lang = req.getHeader("Accept-Language");
        System.out.println(agent);
        System.out.println(lang);

    }

}