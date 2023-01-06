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
    public InMemoryUserDetailsManager inMemory(BCryptPasswordEncoder encoder) {
        return new InMemoryUserDetailsManager(
                User.builder()
                        .passwordEncoder(encoder::encode)
                        .username("u")
                        .password("u")
                        .roles(USER.name())
                        .build(),
                User.builder()
                        .passwordEncoder(encoder::encode)
                        .username("a")
                        .password("a")
                        .roles(ADMIN.name())
                        .build()
        );
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

    //@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests()
                .requestMatchers(
                        "/error",
                        "/registration"
                )
                .permitAll()
                //
                .requestMatchers(
                        "/",
                        "/clients"
                )
                .authenticated()
                //
                .requestMatchers(
                        "/clientUpdate"
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
