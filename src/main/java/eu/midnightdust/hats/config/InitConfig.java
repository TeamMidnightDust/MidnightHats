package eu.midnightdust.hats.config;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.JanksonConfigSerializer;

public class InitConfig {
    public static HatsConfig HATS_CONFIG;

    public static void init() {
        AutoConfig.register(HatsConfig.class, JanksonConfigSerializer::new);
        HATS_CONFIG = AutoConfig.getConfigHolder(HatsConfig.class).getConfig();
    }
}
