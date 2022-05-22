package kz.bitlab.project.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses(){
        return new Class[]{WebMVCConfig.class, HibernateConfig.class, SecurityConfig.class};
    }
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}
