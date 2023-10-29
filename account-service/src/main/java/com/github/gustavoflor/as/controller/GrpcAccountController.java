package com.github.gustavoflor.as.controller;

import com.github.gustavoflor.as.channel.WalletChannel;
import com.github.gustavoflor.as.payload.Account;
import com.github.gustavoflor.wsg.protobuf.WalletStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/grpc/accounts")
@RequiredArgsConstructor
public class GrpcAccountController {

    private final WalletChannel walletChannel;

    @GetMapping("/{number}")
    public Account findByNumber(@PathVariable Long number) {
        final var wallet = walletChannel.findById(3);
        if (wallet.getStatus() == WalletStatus.INACTIVE) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return new Account(number);
    }

}
