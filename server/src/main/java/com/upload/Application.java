package com.upload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
@ComponentScan("com.upload.controller")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
        logger.info("SpringBoot server started on port:23333");
    }

    @Bean
    public ServletRegistrationBean apiRegisteredServletBean(WebApplicationContext wac) {
        DispatcherServlet servlet = new DispatcherServlet(wac);
        ServletRegistrationBean bean = new ServletRegistrationBean(servlet, "/api/*");
        bean.setName("ApiServletBean");
        return bean;
    }
}
