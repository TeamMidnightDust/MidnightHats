// Made with Blockbench 3.6.6
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports

	package eu.midnightdust.hats.bunny;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.AnimalModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;

public class BunnyEarsModel<T extends LivingEntity> extends AnimalModel<T> {
	private final ModelPart right_ear;
	private final ModelPart left_ear;

	public BunnyEarsModel() {
		textureWidth = 64;
		textureHeight = 32;
		right_ear = new ModelPart(this);
		right_ear.setPivot(0.0F, -3.0F, -1.0F);
		right_ear.setTextureOffset(52, 0).addCuboid(-2.5F, -9.0F, -1.0F, 2.0F, 5.0F, 1.0F, 0.0F, false);

		left_ear = new ModelPart(this);
		left_ear.setPivot(0.0F, -3.0F, -1.0F);
		left_ear.setTextureOffset(58, 0).addCuboid(0.5F, -9.0F, -1.0F, 2.0F, 5.0F, 1.0F, 0.0F, false);
}

	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

	}

	@Override
	protected Iterable<ModelPart> getHeadParts() {
		return null;
	}

	@Override
	protected Iterable<ModelPart> getBodyParts() {
		return null;
	}

	@Override
	public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		right_ear.render(matrixStack, buffer, packedLight, packedOverlay);
		left_ear.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelPart bone, float x, float y, float z) {
		bone.pitch = x;
		bone.yaw = y;
		bone.roll = z;
	}
}