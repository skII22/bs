package vueshop.config;

import org.springframework.context.annotation.Configuration;
<<<<<<< HEAD
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import vueshop.interceptor.UserLoginInterceptor;

=======
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
>>>>>>> 32478a31c06519498ac512df3778dd391cd6f415
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/public/**").addResourceLocations("classpath:/public/");
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
<<<<<<< HEAD

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptor = registry.addInterceptor(new UserLoginInterceptor());
        interceptor.addPathPatterns("/**");
        interceptor.excludePathPatterns(
                "/users/login",
                "/user/login",
                "/public/**",
                "/resources/carousel",
                "/product/**",
                "/**/*.html",
                "/**/*.js",
                "/**/*.css");
    }
=======
>>>>>>> 32478a31c06519498ac512df3778dd391cd6f415
}
