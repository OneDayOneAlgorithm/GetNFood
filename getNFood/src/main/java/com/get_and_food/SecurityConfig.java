package com.get_and_food;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
            .antMatchers("/**").permitAll() // 모든 URL에 대해 인증 없이 접근 가능
            .antMatchers(HttpMethod.GET, "/**").permitAll() // 모든 GET API에 대해 인증 없이 접근 가능
            .antMatchers(HttpMethod.POST, "/**").permitAll() // 모든 POST API에 대해 인증 없이 접근 가능
            .antMatchers(HttpMethod.PUT, "/**").permitAll() // 모든 PUT API에 대해 인증 없이 접근 가능
            .antMatchers(HttpMethod.DELETE, "/**").permitAll() // 모든 DELETE API에 대해 인증 없이 접근 가능
            .anyRequest().authenticated();
    }
}