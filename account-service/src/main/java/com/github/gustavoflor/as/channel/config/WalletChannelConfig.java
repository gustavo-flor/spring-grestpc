package com.github.gustavoflor.as.channel.config;

import com.github.gustavoflor.as.channel.WalletChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class WalletChannelConfig {

    private final WalletChannelConfigProperties configProperties;

    @Bean(destroyMethod = "shutdown")
    public WalletChannel channel() {
        final var managedChannel = ManagedChannelBuilder.forAddress(configProperties.getHost(), configProperties.getPort())
            .usePlaintext()
            .build();
        return new WalletChannel(managedChannel);
    }

}
