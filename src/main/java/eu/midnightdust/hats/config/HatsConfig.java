package eu.midnightdust.hats.config;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.shadowed.blue.endless.jankson.Comment;

@Config(name = "midnight-hats")
public class HatsConfig implements ConfigData {
    @Comment(value = "Enable Event Hats (Default: true)")
    public boolean event_hats = true;
}
