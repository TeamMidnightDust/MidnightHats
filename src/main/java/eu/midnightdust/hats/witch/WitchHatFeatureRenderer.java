package eu.midnightdust.hats.witch;

import eu.midnightdust.hats.config.AreEventHatsEnabled;
import eu.midnightdust.hats.web.HatLoader;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.ModelWithHead;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;

import java.util.Calendar;
import java.util.UUID;

@Environment(EnvType.CLIENT)
public class WitchHatFeatureRenderer<T extends LivingEntity, M extends EntityModel<T>> extends FeatureRenderer<T, M> {
    private static final UUID MOTSCHEN = UUID.fromString("a44c2660-630f-478f-946a-e518669fcf0c");

    private static final Identifier DEACTIVATED = new Identifier("midnight-hats:textures/hats/empty.png");
    private static final Identifier WITCH = new Identifier("textures/entity/witch.png");
    private static final Identifier MOTSCHEN_SKIN = new Identifier("midnight-hats:textures/hats/motschen.png");
    private static final Identifier CONTRIBUTER_SKIN = new Identifier("midnight-hats:textures/hats/contributer.png");
    private static final Identifier FRIEND_SKIN = new Identifier("midnight-hats:textures/hats/friend.png");
    private static final Identifier DONATOR_SKIN = new Identifier("midnight-hats:textures/hats/donator.png");
    private static final Identifier SOCIAL_SKIN = new Identifier("midnight-hats:textures/hats/social.png");
    private static final Identifier PRIDE_SKIN = new Identifier("midnight-hats:textures/hats/pride.png");
    private final WitchHatModel<T> witchHat = new WitchHatModel<>();

    public WitchHatFeatureRenderer(LivingEntityRenderer<T, M> livingEntityRenderer) {
        super(livingEntityRenderer);
    }

    public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T livingEntity, float f, float g, float h, float j, float k, float l) {
        {
            Identifier hat_type;
            if (livingEntity instanceof AbstractClientPlayerEntity) {
                AbstractClientPlayerEntity abstractClientPlayerEntity = (AbstractClientPlayerEntity)livingEntity;

                if (abstractClientPlayerEntity.getUuid().equals(MOTSCHEN)) {
                    hat_type = MOTSCHEN_SKIN;
                }else if (HatLoader.PLAYER_HATS.containsKey(abstractClientPlayerEntity.getUuid()) && HatLoader.PLAYER_HATS.get(abstractClientPlayerEntity.getUuid()).getHatType().contains("contributer")) {
                    hat_type = CONTRIBUTER_SKIN;
                }else if (HatLoader.PLAYER_HATS.containsKey(abstractClientPlayerEntity.getUuid()) && HatLoader.PLAYER_HATS.get(abstractClientPlayerEntity.getUuid()).getHatType().contains("friend")) {
                    hat_type = FRIEND_SKIN;
                }else if (HatLoader.PLAYER_HATS.containsKey(abstractClientPlayerEntity.getUuid()) && HatLoader.PLAYER_HATS.get(abstractClientPlayerEntity.getUuid()).getHatType().contains("donator")) {
                    hat_type = DONATOR_SKIN;
                }else if (HatLoader.PLAYER_HATS.containsKey(abstractClientPlayerEntity.getUuid()) && HatLoader.PLAYER_HATS.get(abstractClientPlayerEntity.getUuid()).getHatType().contains("social")) {
                    hat_type = SOCIAL_SKIN;
                }else if (HatLoader.PLAYER_HATS.containsKey(abstractClientPlayerEntity.getUuid()) && HatLoader.PLAYER_HATS.get(abstractClientPlayerEntity.getUuid()).getHatType().contains("pride")) {
                    hat_type = PRIDE_SKIN;
                }else if (Calendar.getInstance().get(Calendar.MONTH) == Calendar.OCTOBER && Calendar.getInstance().get(Calendar.DAY_OF_MONTH) >= 30) {
                    if (FabricLoader.getInstance().isModLoaded("autoconfig1u")) {
                        if (AreEventHatsEnabled.areEventHatsEnabled() == true) {
                            hat_type = WITCH;
                        }
                        else hat_type = DEACTIVATED;
                    }
                    else hat_type = WITCH;
                }else {
                    hat_type = DEACTIVATED;
                }
            } else {
                hat_type = DEACTIVATED;
            }

            if (!(hat_type == DEACTIVATED)) {
                matrixStack.push();

                ((ModelWithHead) this.getContextModel()).getHead().rotate(matrixStack);
                VertexConsumer vertexConsumer = ItemRenderer.getArmorVertexConsumer(vertexConsumerProvider, RenderLayer.getEntityCutoutNoCull(hat_type), false, false);
                this.witchHat.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);

                matrixStack.pop();
            }
        }
    }
}
