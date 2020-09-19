package eu.midnightdust.hats;

import eu.midnightdust.hats.web.HatLoader;
import net.fabricmc.api.ClientModInitializer;

public class HatsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        HatLoader.init();
    }
}
