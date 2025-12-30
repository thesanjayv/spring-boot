package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        
    //     http
    
    // //         .csrf(csrf -> csrf.disable())
    //         .authorizeHttpRequests(auth -> auth
    //         .requestMatchers("/public").permitAll()
    //         .requestMatchers("/admin").hasRole("ADMIN")
    //         .requestMatchers("/user").hasRole("USER")
        // );
	// 	// .httpBasic(h->{});
        // .formLogin(form -> {}
        // );
		
        // return http.build();
    // }


    @Bean
    public UserDetailsService inmemoDetailsService(){
        
        UserDetails user1 = 
        User.withUsername("Sanju")
            .password(passwordEncoder().encode("12345"))
            .roles("ADMIN")
            .build();

        UserDetails user2 =
        User.withUsername("Bro")
            .password(passwordEncoder().encode("12345"))
            .roles("USER")
            .build();

        return new InMemoryUserDetailsManager(user1, user2);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}