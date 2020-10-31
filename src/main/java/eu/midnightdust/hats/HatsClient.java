package eu.midnightdust.hats;

import eu.midnightdust.hats.config.InitConfig;
import eu.midnightdust.hats.web.HatLoader;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class HatsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        if (FabricLoader.getInstance().isModLoaded("autoconfig1u")) {
            InitConfig.init();
        }
        HatLoader.init();
    }
}
