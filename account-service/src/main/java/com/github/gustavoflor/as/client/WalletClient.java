package com.github.gustavoflor.as.client;

import com.github.gustavoflor.as.client.payload.Wallet;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "wallet-service")
public interface WalletClient {

    @GetMapping("/wallets/{id}")
    Wallet findById(@PathVariable Long id);

}
