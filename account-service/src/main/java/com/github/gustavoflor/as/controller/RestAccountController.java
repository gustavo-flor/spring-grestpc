package com.github.gustavoflor.as.controller;

import com.github.gustavoflor.as.client.WalletClient;
import com.github.gustavoflor.as.client.payload.WalletStatus;
import com.github.gustavoflor.as.payload.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/rest/accounts")
@RequiredArgsConstructor
public class RestAccountController {

    private final WalletClient walletClient;

    @GetMapping("/{number}")
    public Account findByNumber(@PathVariable Long number) {
        final var wallet = walletClient.findById(3L);
        if (wallet.status() == WalletStatus.INACTIVE) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return new Account(number);
    }

}
