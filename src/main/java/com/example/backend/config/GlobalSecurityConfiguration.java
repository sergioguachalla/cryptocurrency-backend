package com.example.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class GlobalSecurityConfiguration {
    private final KeycloakJwtTokenConverter keycloakJwtTokenConverter;

    public GlobalSecurityConfiguration(TokenConverterProperties properties){
        JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter
                = new JwtGrantedAuthoritiesConverter();
        this.keycloakJwtTokenConverter
                = new KeycloakJwtTokenConverter(
                jwtGrantedAuthoritiesConverter,
                properties);
    }

     @Bean
     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorizeHttpRequests ->{
            authorizeHttpRequests
                    .requestMatchers("/api/v1/cryptocurrency").hasRole("VIEW-CRYPTOS")
                    .requestMatchers("api/v1/cryptocurrency/{id}/price").hasRole("VIEW-CRYPTOS")
                    .requestMatchers("/api/v1/cryptocurrency/{id}").hasRole("VIEW-CRYPTOS")
                    .requestMatchers("/api/v1/transactions").authenticated()
                    .requestMatchers("/api/v1/transactions/{id}/").permitAll()
                    .requestMatchers("api/v1/user").authenticated()
                    .anyRequest()
                    .denyAll();

        }));
        http.oauth2ResourceServer((oauth2 ->{
            oauth2.jwt((jwt ->{
                jwt.jwtAuthenticationConverter(keycloakJwtTokenConverter);
            }));
        }));
        http.sessionManagement((session ->{
            session.sessionCreationPolicy((SessionCreationPolicy.STATELESS));
        }));

        http.cors(withDefaults());


         return http.build();
     }


}
