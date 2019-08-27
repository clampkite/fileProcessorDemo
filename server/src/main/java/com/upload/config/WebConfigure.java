package com.upload.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebConfigure extends WebMvcConfigurationSupport {

    @Autowired
    PreparedUploadConfig uploadConfig;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(uploadConfig.getStaticAccessPath()).addResourceLocations("file:" + uploadConfig.getUploadFolder());
        super.addResourceHandlers(registry);
    }
}
