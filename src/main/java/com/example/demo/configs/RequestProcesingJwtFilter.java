package com.example.demo.configs;

import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RequestProcesingJwtFilter extends GenericFilterBean {

    //    рефгує на всі URL
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        Authentication authentication = null;

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        String token = httpServletRequest.getHeader("Authorization");
        String role = httpServletRequest.getHeader("Role");




        System.out.println("-------------------");
        System.out.println(token);
        if (token != null) {
            String username = Jwts.parser()
                    .setSigningKey("yes".getBytes())
                    .parseClaimsJws(token)
                    .getBody().getSubject();
            System.out.println(username);
            List<GrantedAuthority> roles = new ArrayList<>();
            roles.add(new SimpleGrantedAuthority(role.substring(1, role.length() - 1)));

            authentication = new UsernamePasswordAuthenticationToken(username, null, roles);
            System.out.println(authentication.isAuthenticated());
            System.out.println(authentication.getAuthorities());
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
