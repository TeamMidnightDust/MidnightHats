package eu.midnightdust.hats.tater;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.AnimalModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;

public class TinyPotatoModel <T extends LivingEntity> extends AnimalModel<T> {
	private final ModelPart tater;
	public TinyPotatoModel() {
		textureWidth = 16;
		textureHeight = 16;
		tater = new ModelPart(this);
		tater.setPivot(0.0F, -8.0F, 0.0F);
		tater.setTextureOffset(0, 0).addCuboid(-2.0F, -6.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}
	@Override
	public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		
		tater.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	@Override
	protected Iterable<ModelPart> getHeadParts() {
		return null;
	}

	@Override
	protected Iterable<ModelPart> getBodyParts() {
		return null;
	}

	public void setRotationAngle(ModelPart bone, float x, float y, float z) {
		bone.pitch = x;
		bone.yaw = y;
		bone.roll = z;
	}
}