package com.github.gustavoflor.wsr.controller;

import com.github.gustavoflor.wsr.payload.User;
import com.github.gustavoflor.wsr.payload.Wallet;
import com.github.gustavoflor.wsr.payload.WalletStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/v1/wallets")
public class WalletController {

    @GetMapping("/{id}")
    public Wallet findById(@PathVariable Long id) {
        final var user = new User("Post Malone", true);
        return Wallet.builder()
            .description("Checking account's wallet")
            .status(WalletStatus.ACTIVE)
            .available(BigDecimal.valueOf(150))
            .saved(BigDecimal.valueOf(100))
            .blocked(BigDecimal.valueOf(50))
            .user(user)
            .tags(List.of("102% CDI", "D+1", "Vacation"))
            .createdAt(LocalDateTime.now().minusDays(3))
            .updatedAt(LocalDateTime.now().minusDays(1))
            .build();
    }

}
