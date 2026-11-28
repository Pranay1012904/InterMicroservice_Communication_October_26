package com.microservice.employee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
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
    //Basic Http Auth---------------------------------------------------------------------------
    @Bean
    SecurityFilterChain defaultFilterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests((authorize) ->
                        //authorize.anyRequest().authenticated()
                        authorize.requestMatchers(HttpMethod.GET,"/employee/api/**").permitAll()
                                .anyRequest().authenticated()
                ).httpBasic((Customizer.withDefaults()));

        return http.build();
    }
    //-------------------------------------------------------------------------------------------

    //--IN-MEMORY-AUTH---------------------------------------------------------------------------
    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails user = User.builder()
                .username("Pranay")
                .password(passwordEncoder().encode("Pranay"))
                .roles("USER")
                .build();

        UserDetails user2 = User.builder()
                .username("Ranjan")
                .password(passwordEncoder().encode("Ranjan"))
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                .username("Admin")
                .password(passwordEncoder().encode("Admin"))
                .roles("ADMIN")
                .build();


        return new InMemoryUserDetailsManager(user, user2, admin);
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    //-----------------------------------------------------------------------------------------
}
