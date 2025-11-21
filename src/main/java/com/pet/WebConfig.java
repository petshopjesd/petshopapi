package com.pet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.Collections;

@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean<CorsFilter> simpleCorsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // 1. Permite que las peticiones incluyan credenciales (cookies, tokens de autenticación, etc.)
        config.setAllowCredentials(true);

        // 2. Define los orígenes permitidos explícitamente.
        //    Se incluye la URL de producción y las URLs comunes de desarrollo local.
        config.setAllowedOrigins(Arrays.asList(
                "https://petshop-1-kepc.onrender.com",
                "http://localhost:3000", // Para React
                "http://localhost:4200", // Para Angular
                "http://localhost:5173"  // Para Vite
        ));

        // 3. Define los métodos HTTP permitidos.
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // 4. Permite todas las cabeceras estándar.
        config.setAllowedHeaders(Collections.singletonList("*"));

        source.registerCorsConfiguration("/**", config);

        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));

        // Dale a este filtro la máxima prioridad para que se ejecute antes que otros
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);

        return bean;
    }
}
