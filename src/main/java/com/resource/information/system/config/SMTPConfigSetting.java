package com.resource.information.system.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("SMTPSettings")
public class SMTPConfigSetting {

    @Value("${smtp.port}")
    private Integer port;
}
