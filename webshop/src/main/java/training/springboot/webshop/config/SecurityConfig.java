package training.springboot.webshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Component
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(HttpMethod.GET).hasAnyRole("USER", "ADMIN")
                .requestMatchers(HttpMethod.POST).hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE).hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT).hasRole("ADMIN")
            )
            .httpBasic(Customizer.withDefaults());


        http.csrf(csrf -> csrf.disable());
        return http.build();
    }

    @Bean
    public UserDetailsService users() {
        // The builder will ensure the passwords are encoded before saving in memory
        UserBuilder users = User.withDefaultPasswordEncoder();
        UserDetails user = users
            .username("user")
            .password("password")
            .roles("USER")
            .build();
        UserDetails admin = users
            .username("admin")
            .password("password")
            .roles( "ADMIN")
            .build();
        return new InMemoryUserDetailsManager(user, admin);
    }
}
