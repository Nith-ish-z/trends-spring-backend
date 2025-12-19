package com.ecom.trends.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class SameSiteCookieFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException {

        chain.doFilter(request, response);

//        ====== ONLY FOR SAMESITE OR DEVELOPMENT +++++++++++
//        if (response instanceof HttpServletResponse res) {
//            res.setHeader(
//                    "Set-Cookie",
//                    "JSESSIONID=; SameSite=None; Secure"
//            );
//        }
    }
}
