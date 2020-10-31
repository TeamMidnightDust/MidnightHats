package eu.midnightdust.hats.config;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;

public class AreEventHatsEnabled {
    private static final HatsConfig config = AutoConfig.getConfigHolder(HatsConfig.class).getConfig();

    public static boolean areEventHatsEnabled() {
        return config.event_hats;
    }
}
