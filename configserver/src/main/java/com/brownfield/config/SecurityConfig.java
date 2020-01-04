package com.brownfield.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                //.requestMatchers(EndpointRequest.to("env")).permitAll()
                //.requestMatchers(EndpointRequest.toAnyEndpoint()).hasRole("ACTUATOR")
                //.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .antMatchers("/actuator/**").permitAll() // === management.security.enabled=false
                .antMatchers("/**").permitAll()
                .and()
                .httpBasic();
    }


}
