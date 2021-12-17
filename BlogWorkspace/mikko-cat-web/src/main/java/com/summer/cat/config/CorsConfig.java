package com.summer.cat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 处理跨域问题
 *
 * @author : summer
 * @date : 2018/05/08
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
//    private CorsConfiguration buildConfig() {
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        // 1允许服务端访问
//        corsConfiguration.addAllowedOrigin("*");
//        // 1.1允许本地访问
//        corsConfiguration.addAllowedOrigin("http://localhost:4200");
//        // 2允许任何头
//        corsConfiguration.addAllowedHeader("*");
//        // 3允许任何方法（post、get等）
//        corsConfiguration.addAllowedMethod("*");
//        // 4 允许withCredentials报文头
//        corsConfiguration.setAllowCredentials(true);
//        return corsConfiguration;
//    }
//
//    @Bean
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", buildConfig());
//        return new CorsFilter(source);
//    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOriginPatterns("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(true).maxAge(3600);
    }
}
