package eu.midnightdust.hats.tater;

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
public class TinyPotatoFeatureRenderer<T extends LivingEntity, M extends EntityModel<T>> extends FeatureRenderer<T, M> {
    private static final UUID MOTSCHEN = UUID.fromString("a44c2660-630f-478f-946a-e518669fcf0c");

    private static final Identifier DEACTIVATED = new Identifier("midnight-hats:textures/hats/empty.png");
    private static final Identifier TATER = new Identifier("midnight-hats:textures/hats/tater.png");
    private final TinyPotatoModel<T> tinyPotato = new TinyPotatoModel<>();

    public TinyPotatoFeatureRenderer(LivingEntityRenderer<T, M> livingEntityRenderer) {
        super(livingEntityRenderer);
    }

    public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T livingEntity, float f, float g, float h, float j, float k, float l) {
        {
            AbstractClientPlayerEntity abstractClientPlayerEntity = (AbstractClientPlayerEntity)livingEntity;
            Identifier hat_type;
            if (livingEntity instanceof AbstractClientPlayerEntity) {

                if (Calendar.getInstance().get(Calendar.MONTH) == Calendar.DECEMBER && Calendar.getInstance().get(Calendar.DAY_OF_MONTH) == 10) {
                    if (FabricLoader.getInstance().isModLoaded("autoconfig1u")) {
                        if (AreEventHatsEnabled.areEventHatsEnabled() == true) {
                            hat_type = TATER;
                        }
                        else hat_type = DEACTIVATED;
                    }
                    else hat_type = TATER;
                }else {
                    hat_type = DEACTIVATED;
                }
            } else {
                hat_type = DEACTIVATED;
            }

            if (!(hat_type == DEACTIVATED) && !HatLoader.PLAYER_HATS.containsKey(abstractClientPlayerEntity.getUuid()) && !abstractClientPlayerEntity.getUuid().equals(MOTSCHEN)) {
                matrixStack.push();

                ((ModelWithHead) this.getContextModel()).getHead().rotate(matrixStack);
                VertexConsumer vertexConsumer = ItemRenderer.getArmorVertexConsumer(vertexConsumerProvider, RenderLayer.getEntityCutoutNoCull(hat_type), false, false);
                this.tinyPotato.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);

                matrixStack.pop();
            }
        }
    }
}
