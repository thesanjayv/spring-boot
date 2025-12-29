package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    

    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        
    //     http
    
    //         .csrf(csrf -> csrf.disable())
    //         .authorizeHttpRequests(auth -> auth
    //         .requestMatchers("/public").permitAll()
    //         .requestMatchers("/admin").hasRole("ADMIN")
    //         .requestMatchers("/user").hasRole("USER")
    //     )
    //     .formLogin(form -> form.permitAll());
    //     return http.build();
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


// package com.example.demo.configuration;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {

//     // Security configuration for HTTP requests and authentication
//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http
//             .csrf(csrf -> csrf.disable())  // Disable CSRF for development (not recommended for production)
//             .authorizeHttpRequests(auth -> auth
//                 .requestMatchers("/public").permitAll()  // Allow access to /public without authentication
//                 .requestMatchers("/admin").hasRole("ADMIN")  // Only users with 'ADMIN' role can access /admin
//                 .requestMatchers("/user").hasRole("USER")  // Only users with 'USER' role can access /user
//                 .anyRequest().authenticated()  // All other requests require authentication
//             )
//             .formLogin(form -> form
//                 .permitAll()  // Allow everyone to access the login page
//             );

//         return http.build();
//     }

//     // UserDetailsService to configure in-memory users with roles
//     @Bean
//     public UserDetailsService inmemoDetailsService() {
//         UserDetails user1 = User.withUsername("Sanju")
//             .password(passwordEncoder().encode("12345"))
//             .roles("ADMIN")  // Assign 'ADMIN' role to Sanju
//             .build();

//         UserDetails user2 = User.withUsername("Bro")
//             .password(passwordEncoder().encode("12345"))
//             .roles("USER")  // Assign 'USER' role to Bro
//             .build();

//         return new InMemoryUserDetailsManager(user1, user2);
//     }

//     // Password encoder using BCrypt for securely storing passwords
//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
// }
