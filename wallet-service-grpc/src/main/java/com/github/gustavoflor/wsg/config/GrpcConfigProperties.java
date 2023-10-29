package com.github.gustavoflor.wsg.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "grpc.server")
public class GrpcConfigProperties {

    private int port = 9090;

}
