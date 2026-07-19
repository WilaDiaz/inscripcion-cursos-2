package com.duoc.inscripcion_cursos.config;

import java.util.ArrayList;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/cursos/**", "/bff/**")
                    .hasAnyRole("ALUMNO", "PROFESOR")

                .requestMatchers("/inscripciones/**")
                    .hasAnyRole("ALUMNO", "PROFESOR")

                .requestMatchers("/resumenes/**", "/s3/**")
                    .hasRole("PROFESOR")

                .anyRequest()
                    .authenticated()
            )
            .oauth2ResourceServer(oauth2 ->
                oauth2.jwt(jwt ->
                    jwt.jwtAuthenticationConverter(jwtAuthenticationConverter())
                )
            );

        return http.build();
    }

    @Bean
public Converter<Jwt, AbstractAuthenticationToken> jwtAuthenticationConverter() {

    JwtAuthenticationConverter converter = new JwtAuthenticationConverter();

    converter.setJwtGrantedAuthoritiesConverter(jwt -> {

        List<GrantedAuthority> authorities = new ArrayList<>();

        String rol = jwt.getClaimAsString("extension_rol");

        if (rol != null && !rol.isBlank()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + rol));
        }

        return authorities;
    });

    return converter;

    }
}