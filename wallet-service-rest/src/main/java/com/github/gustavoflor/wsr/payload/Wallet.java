package com.github.gustavoflor.wsr.payload;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Builder
public record Wallet(String description,
                     WalletStatus status,
                     BigDecimal available,
                     BigDecimal saved,
                     BigDecimal blocked,
                     User user,
                     List<String> tags,
                     LocalDateTime createdAt,
                     LocalDateTime updatedAt) {

}
