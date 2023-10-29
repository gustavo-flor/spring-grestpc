package com.github.gustavoflor.as.channel;

import com.github.gustavoflor.wsg.protobuf.FindByIdRequest;
import com.github.gustavoflor.wsg.protobuf.Wallet;
import com.github.gustavoflor.wsg.protobuf.WalletServiceGrpc;
import io.grpc.ManagedChannel;

public class WalletChannel {

    private final ManagedChannel managedChannel;
    private final WalletServiceGrpc.WalletServiceBlockingStub walletServiceBlockingStub;

    public WalletChannel(final ManagedChannel managedChannel) {
        this.managedChannel = managedChannel;
        this.walletServiceBlockingStub = WalletServiceGrpc.newBlockingStub(managedChannel);
    }

    public Wallet findById(long id) {
        final var request = FindByIdRequest.newBuilder()
            .setId(id)
            .build();
        return walletServiceBlockingStub.findById(request);
    }

    public void shutdown() {
        managedChannel.shutdown();
    }

}
