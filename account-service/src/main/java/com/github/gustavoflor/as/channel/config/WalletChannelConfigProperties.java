package com.github.gustavoflor.as.channel.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "grpc.client.config.wallet-service")
public class WalletChannelConfigProperties {

    private String host;
    private int port;

}
