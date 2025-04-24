package com.crud.employee.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    
    @Autowired
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .httpBasic()
                .and().authorizeHttpRequests()
                //.anyRequest().permitAll()
//                .requestMatchers("/demo").permitAll()
                .requestMatchers("/login").hasRole("ADMIN")
//                .requestMatchers("/dba").hasAnyRole("DBA", "ADMIN")
//               .requestMatchers(HttpMethod.POST, "/add").hasRole("ADMIN")
//              .requestMatchers(HttpMethod.GET, "/add").authenticated()
                .and().csrf().disable().build();
    }


    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.withUsername("user")
                        .password(encoder.encode("password"))
                        .authorities("read","ROLE_USER")
                        .build(),
                User.withUsername("admin")
                        .password(encoder.encode("password"))
                        .authorities("read", "write", "ROLE_ADMIN")
                        .build(),
                User.withUsername("user2")
                        .password(encoder.encode("password"))
                        .authorities("read", "ROLE_DBA")
                        .build()
        );
    }
}
