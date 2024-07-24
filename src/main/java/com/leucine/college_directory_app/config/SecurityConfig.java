package com.leucine.college_directory_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails studentUser = User.withUsername("student")
                .password(passwordEncoder().encode("password"))
                .roles("STUDENT")
                .build();

        UserDetails facultyMember = User.withUsername("faculty")
                .password(passwordEncoder().encode("password"))
                .roles("FACULTY_MEMBER")
                .build();

        UserDetails adminUser = User.withUsername("leucine")
                .password(passwordEncoder().encode("password"))
                .roles("ADMINISTRATOR")
                .build();

        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager(
                studentUser,
                facultyMember,
                adminUser);
        return inMemoryUserDetailsManager;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable().authorizeHttpRequests()

             //   .requestMatchers("/home/admin/**")
             //   .hasRole("ADMIN")
             //   .requestMatchers("/home/normal")
             //   .hasRole("NORMAL")

                .requestMatchers("/api/bruhs/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();
        return httpSecurity.build();
    }
}
