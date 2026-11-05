package com.roshini.task1.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// bean tells spring to create object and manage it in spring container so here bean is used to create and manage securityfilterchain
//filterchain is the sqecnce of filter for security check
@Configuration
public class SecurityConfig {

    private final JwtFilter jwtFilter;
    public SecurityConfig(JwtFilter jwtFilter){
        this.jwtFilter=jwtFilter;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((auth) -> auth //thisis lamba expresssion
                        .requestMatchers("/register","/swagger-ui/**","/login","/v3/api-docs/**"
                        ).permitAll()
                        .anyRequest().authenticated()
                )
                        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build(); //used to combine all configuration together

    }
}

