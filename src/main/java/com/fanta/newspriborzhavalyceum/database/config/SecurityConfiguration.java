package com.fanta.newspriborzhavalyceum.database.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import static com.fanta.newspriborzhavalyceum.database.entity.Permission.*;
import static com.fanta.newspriborzhavalyceum.database.entity.Role.ADMIN;
import static com.fanta.newspriborzhavalyceum.database.entity.Role.MANAGER;
import static org.springframework.http.HttpMethod.*;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {

    private static final String[] WHITE_LIST_URL = {"/",
            "/html/error.html",
            "/html/resources.html",
            "/html/sign-up.html",
            "/html/log-in.html",
            "/html/home.html",
            "/html/test.html",
            "/api/events",
            "/api/events/new",
            "/html/new-event.html",
    };

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    private final LogoutHandler logoutHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http

                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req ->
                        req.requestMatchers(WHITE_LIST_URL).permitAll() // Permit all requests to the root URL
                                .requestMatchers(HttpMethod.POST, "/api/users").permitAll() // Allow POST requests to /registration endpoint
                                .requestMatchers(HttpMethod.POST, "/api/authentication").permitAll() // Allow POST requests to /registration endpoint
                                .requestMatchers(HttpMethod.GET, "/api/events").permitAll() // Allow POST requests to /registration endpoint
                                .requestMatchers(POST, "/api/events/new").permitAll() // Allow POST requests to /registration endpoint
//                                .requestMatchers(GET, "/html/new-event.html").hasAnyAuthority(ADMIN_CREATE.name())
//                                .requestMatchers(POST, "/html/new-event.html").hasAnyAuthority(ADMIN_READ.name())
//                                .requestMatchers(PUT, "/html/new-event.html").hasAnyAuthority(ADMIN_UPDATE.name())
//                                .requestMatchers(DELETE, "/api/v1/management/**").hasAnyAuthority(ADMIN_DELETE.name())
                                .requestMatchers("/css/**").permitAll() // Allow all requests to /css/**
                                .requestMatchers("/scripts/**").permitAll()
                                .requestMatchers("/image/**").permitAll()
                                .anyRequest()
                                .authenticated()
                )

                .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .logout(logout ->
                        logout.logoutUrl("/logout")
                                .addLogoutHandler(logoutHandler)
                                .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
                )

        ;

        return http.build();
    }

}
