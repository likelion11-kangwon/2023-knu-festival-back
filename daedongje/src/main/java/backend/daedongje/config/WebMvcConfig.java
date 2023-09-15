package backend.daedongje.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(final CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") //외부에서 들어오는 모둔 url 을 허용
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS") // GET, POST, PUT, PATCH, DELETE, OPTIONS 메서드를 허용한다.
                .allowedHeaders("*")    //허용되는 헤더
                .allowCredentials(true);    //자격증명 허용
    }
}