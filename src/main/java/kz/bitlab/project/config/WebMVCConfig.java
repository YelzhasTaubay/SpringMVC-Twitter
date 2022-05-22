package kz.bitlab.project.config;

import kz.bitlab.project.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"kz.bitlab.project"})
public class WebMVCConfig implements WebMvcConfigurer {

    @Bean
    public InternalResourceViewResolver resolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry){

        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");

    }

    @Bean
    public UserService userService(){
        return new UserService();
    }
}
