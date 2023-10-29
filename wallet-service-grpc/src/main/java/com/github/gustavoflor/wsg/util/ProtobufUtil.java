package com.github.gustavoflor.wsg.util;

import com.google.protobuf.Timestamp;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProtobufUtil {

    public static Timestamp timestamp(final LocalDateTime value) {
        if (value == null) {
            return Timestamp.getDefaultInstance();
        }
        return Timestamp.newBuilder()
            .setSeconds(value.toEpochSecond(ZoneOffset.UTC))
            .setNanos(value.getNano())
            .build();
    }

}
