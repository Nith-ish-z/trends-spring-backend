package com.ecom.trends.config;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http,SessionAuthFilter sessionAuthFilter) throws Exception {

        http.csrf(AbstractHttpConfigurer::disable) // CSRF disable with new syntax
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .addFilterBefore(sessionAuthFilter, UsernamePasswordAuthenticationFilter.class)

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/", "/login", "/signup", "/signup/verify", "/user",
                                "/f" , "/product/categories"
                        ).permitAll()

                        .requestMatchers("/cart/**", "/wishlist/**","/cart","/user/**","/logout")
                        .hasAnyRole("CUSTOMER", "MEMBER", "MANAGER", "ADMIN")

                        .requestMatchers("/admin/create/**")
                        .hasAnyRole("MEMBER", "MANAGER", "ADMIN")


                        .requestMatchers("/admin/delete/**","admin/product/**","admin/home")
                        .hasAnyRole("MANAGER","ADMIN")

                        .requestMatchers("admin/users","admin/users/**")
                        .hasRole("ADMIN")

                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                                .sessionFixation().migrateSession()
                )
                .httpBasic(AbstractHttpConfigurer::disable)
                .logout(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable);

        return http.build();
    }


//    @Bean
//    public ServletContextInitializer sameSiteCookieConfig() {
//        return servletContext -> {
//            var sessionCookieConfig = servletContext.getSessionCookieConfig();
////            sessionCookieConfig.setHttpOnly(false); ======= ONLY FOR DEVELOPMENT OR SAME SITE ++++++++++
//            sessionCookieConfig.setSecure(true); // since localhost is HTTP
//            sessionCookieConfig.setMaxAge(1000);
//        };
//    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public org.springframework.web.cors.CorsConfigurationSource corsConfigurationSource() {

        var config = new org.springframework.web.cors.CorsConfiguration();
        config.setAllowedOrigins(List.of("https://trends-next-frontend.vercel.app","https://trends-next-frontend-git-main-nithishs-projects-dcda88c2.vercel.app","https://trends-next-frontend-g0air6kf5-nithishs-projects-dcda88c2.vercel.app","https://trends-next-frontend-nithishs-projects-dcda88c2.vercel.app"));  // ALLOW ALL
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        config.setAllowCredentials(true);     // REQUIRED

        var source = new org.springframework.web.cors.UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return source;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
