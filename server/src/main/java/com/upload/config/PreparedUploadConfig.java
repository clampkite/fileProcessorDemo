package com.upload.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="file")
public class PreparedUploadConfig {
    private String uploadFolder;
    private String staticAccessPath;

    public String getUploadFolder() {
        return this.uploadFolder;
    }

    public void setUploadFolder(String uploadFolder) {
        this.uploadFolder = uploadFolder;
    }

    public String getStaticAccessPath() {
        return staticAccessPath;
    }

    public void setStaticAccessPath(String staticAccessPath) {
        this.staticAccessPath = staticAccessPath;
    }
}
