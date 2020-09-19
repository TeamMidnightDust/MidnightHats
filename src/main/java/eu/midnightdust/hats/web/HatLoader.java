package eu.midnightdust.hats.web;

import com.google.common.reflect.TypeToken;
import net.minecraft.client.MinecraftClient;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.CompletableFuture;

import static net.minecraft.datafixer.fix.BlockEntitySignTextStrictJsonFix.GSON;

public class HatLoader {
    public static final Logger logger = LogManager.getLogger("MidnightHats");
    private final static String HATS_URL = "https://raw.githubusercontent.com/TeamMidnightDust/MidnightHats/master/hats.json";
    public static final Type HAT_TYPE = new TypeToken<Map<UUID, PlayerHatData>>(){}.getType();
    public static Map<UUID, PlayerHatData> PLAYER_HATS;

    public static void init() {
        CompletableFuture.supplyAsync(() -> {
            try (Reader reader = new InputStreamReader(new URL(HATS_URL).openStream())) {
                Map<UUID, PlayerHatData> playerData = GSON.fromJson(reader, HAT_TYPE);
                return playerData;
            } catch (MalformedURLException error) {
                logger.log(Level.ERROR, "Unable to load player hats because of connection problems: " + error.getMessage());
            } catch (IOException error) {
                logger.log(Level.ERROR, "Unable to load player hats because of an I/O Exception: " + error.getMessage());
            }

            return null;
        }).thenAcceptAsync(playerData -> {
            if (playerData != null) {
                PLAYER_HATS = playerData;
                logger.log(Level.INFO, "Player hats successfully loaded!");
            } else {
                PLAYER_HATS = Collections.emptyMap();
                logger.log(Level.WARN, "A problem with the database occured, the hats could not be initialized.");
            }
        }, MinecraftClient.getInstance());
    }
}
