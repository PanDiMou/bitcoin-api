package io.api.bitcoin.utils;

import java.util.List;
import java.util.ArrayList;
import io.api.bitcoin.dto.out.*;
import io.api.bitcoin.model.out.*;
import org.springframework.util.ObjectUtils;

public class Converter {
    //-------
    public static CreateWalletOutModel toOutModel(final CreateWalletRpcOutDto input) {
        return new CreateWalletOutModel(input.id(), input.result().name());
    }
    //##################################################################################################################

    //-------
    public static BalancesOutModel toOutModel(final BalancesRpcOutDto input) {
        BalancesOutModel.WatchOnly watchOnly = null;
        if (!ObjectUtils.isEmpty(input.result().watchOnly())) {
            watchOnly = new BalancesOutModel.WatchOnly(
                    input.result().watchOnly().trusted(),
                    input.result().watchOnly().untrustedPending(),
                    input.result().watchOnly().immature()
            );
        }

        return new BalancesOutModel(
                input.id(),
                new BalancesOutModel.Mine(
                        input.result().mine().trusted(),
                        input.result().mine().untrustedPending(),
                        input.result().mine().immature(),
                        input.result().mine().used()
                ),
                watchOnly,
                new BalancesOutModel.LastProcessedBlock(
                        input.result().lastProcessedBlock().hash(),
                        input.result().lastProcessedBlock().height()
                )
        );
    }
    //##################################################################################################################

    //-------
    public static ListWalletsOutModel toOutModel(final ListWalletsRpcOutDto input) {
        return new ListWalletsOutModel(input.id(), input.result());
    }
    //##################################################################################################################

    //-------
    public static BestBlockHashOutModel toOutModel(final BestBlockHashRpcOutDto input) {
        return new BestBlockHashOutModel(input.id(), input.result());
    }
    //##################################################################################################################

    //-------
    public static UptimeOutModel toOutModel(final UptimeRpcOutDto input) {
        return new UptimeOutModel(input.id(), input.result());
    }
    //##################################################################################################################

    //-------
    public static StopOutModel toOutModel(final StopRpcOutDto input) {
        return new StopOutModel(input.id(), input.result());
    }
    //##################################################################################################################

    //-------
    public static RpcInfoOutModel toOutModel(final RpcInfoRpcOutDto input) {
        final List<RpcInfoOutModel.ActiveCommand> activeCommands = new ArrayList<>();
        input.result()
                .activeCommands()
                .forEach(activeCommand -> activeCommands.add(
                        new RpcInfoOutModel.ActiveCommand(activeCommand.method(),activeCommand.duration())
                )
        );
        return new RpcInfoOutModel(input.id(), activeCommands, input.result().logPath());
    }
    //##################################################################################################################
}
