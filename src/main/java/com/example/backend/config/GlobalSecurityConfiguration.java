package com.example.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

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
        http.authorizeHttpRequests((authorizedHttpRequests ->{
            authorizedHttpRequests
                    .requestMatchers("api/v1/cryptocurrency").permitAll()
                    .requestMatchers("api/v1/cryptocurrency/{id}").hasRole("DELETE-CRYPTO")
                    .anyRequest()
                    .authenticated();

        }));
        http.oauth2ResourceServer((oauth2 ->{
            oauth2.jwt((jwt ->{
                jwt.jwtAuthenticationConverter(keycloakJwtTokenConverter);
            }));
        }));
        http.sessionManagement((session ->{
            session.sessionCreationPolicy((SessionCreationPolicy.STATELESS));
        }));

         return http.build();
     }

}
