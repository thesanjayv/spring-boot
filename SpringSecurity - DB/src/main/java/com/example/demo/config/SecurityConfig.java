package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http){
        http 
            .csrf(csrf -> csrf.disable()
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/public").permitAll()
                .requestMatchers("/users/post", "/users/read").hasAnyRole("ADMIN")
                .requestMatchers("/users/read").hasRole("USER")
            )
        ).httpBasic(h -> {});
            
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public UserDetailsService userDetailsService(){

        UserDetails admin = User.withUsername("admin")
        .password(passwordEncoder().encode("12345"))
        .roles("ADMIN")
        .build();

        UserDetails user = User.withUsername("user")
        .password(passwordEncoder().encode("12345"))
        .roles("USER")
        .build();

        return new InMemoryUserDetailsManager(admin, user);
    }

    public AuthenticationManager authenticationManager(AuthenticationConfiguration ac) throws Exception{
        return ac.getAuthenticationManager();
    }
}
