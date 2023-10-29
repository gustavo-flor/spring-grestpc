package com.github.gustavoflor.wsg.service;

import com.github.gustavoflor.wsg.mapping.GrpcService;
import com.github.gustavoflor.wsg.protobuf.*;
import io.grpc.stub.StreamObserver;

import java.time.LocalDateTime;
import java.util.List;

import static com.github.gustavoflor.wsg.util.ProtobufUtil.timestamp;

@GrpcService
public class WalletService extends WalletServiceGrpc.WalletServiceImplBase {

    @Override
    public void findById(final FindByIdRequest request, final StreamObserver<Wallet> responseObserver) {
        final var user = User.newBuilder()
            .setFullName("Post Malone")
            .setPep(true)
            .build();
        final var wallet = Wallet.newBuilder()
            .setDescription("Checking account's wallet")
            .setStatus(WalletStatus.ACTIVE)
            .setAvailable(150)
            .setSaved(100)
            .setBlocked(50)
            .setUser(user)
            .addAllTags(List.of("102% CDI", "D+1", "Vacation"))
            .setCreatedAt(timestamp(LocalDateTime.now().minusDays(3)))
            .setUpdatedAt(timestamp(LocalDateTime.now().minusDays(1)))
            .build();
        responseObserver.onNext(wallet);
        responseObserver.onCompleted();
    }

}
