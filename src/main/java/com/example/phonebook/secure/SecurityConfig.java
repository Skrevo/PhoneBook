package com.example.phonebook.secure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static com.example.phonebook.models.User.Role.*;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity security,
                                             BCryptPasswordEncoder passwordEncoder,
                                             UserDetailsService userDetailsService) throws Exception {
        return security
                .getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder)
                .and().build();

    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .antMatchers(
                        "/error",
                        "/registration"
                )
                .permitAll()
                //
                .antMatchers(
                        "/",
                        "/contacts"
                )
                .authenticated()
                //
                .antMatchers(
                        "/contactUpdate"
                )
                .hasAnyAuthority(
                        ADMIN.name()
                )
                //
                .and()
                .formLogin()
                .loginPage(
                        "/authorization"
                )
                //
                .and()
                .logout()
                .logoutSuccessUrl(
                        "/authorization"
                )
        ;
        return httpSecurity.build();
    }
}
