/*package com.pet;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.web.servlet.config.annotation.CorsRegistry;
    import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

    @Configuration
    public class WebConfig {

        @Bean
        public WebMvcConfigurer corsConfigurer() {
            return new WebMvcConfigurer() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    // Permite peticiones de cualquier origen a todos los endpoints de la aplicación
                    registry.addMapping("/**")
                            .allowedOrigins("*") // Permite cualquier origen (dominio)
                            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos HTTP permitidos
                            .allowedHeaders("*"); // Cabeceras permitidas
                }
            };
        }
    }*/
package com.pet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Collections;

@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean<CorsFilter> simpleCorsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // 1. Permite que las peticiones incluyan credenciales (cookies, tokens de autenticación, etc.)
        config.setAllowCredentials(true);

        // 2. USA setAllowedOriginPatterns en lugar de setAllowedOrigins.
        //    Esto es compatible con allowCredentials = true y el comodín "*".
        config.setAllowedOriginPatterns(Collections.singletonList("*"));

        // Permite todas las cabeceras
        config.setAllowedHeaders(Collections.singletonList("*"));

        // Permite todos los métodos HTTP (GET, POST, etc.)
        config.setAllowedMethods(Collections.singletonList("*"));

        source.registerCorsConfiguration("/**", config);

        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));

        // Dale a este filtro la máxima prioridad para que se ejecute antes que otros
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);

        return bean;
    }
}
