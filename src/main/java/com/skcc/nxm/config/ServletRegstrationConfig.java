package com.skcc.nxm.config;

/*
multi servlet 등록 (예: web.xml 등록한 서블릿)
 */

import com.skcc.nxm.custom_servlet.MainController;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletRegstrationConfig {

    @Bean
    public ServletRegistrationBean MainController(){
        ServletRegistrationBean MainController = new ServletRegistrationBean<>(new MainController());
        MainController.addUrlMappings("/SVC");
        return MainController;
    }
}
