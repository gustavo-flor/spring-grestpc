package com.github.gustavoflor.as.client.payload;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

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
