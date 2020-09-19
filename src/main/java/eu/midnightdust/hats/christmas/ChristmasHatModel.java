package eu.midnightdust.hats.christmas;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.AnimalModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;

public class ChristmasHatModel<T extends LivingEntity> extends AnimalModel<T> {
	private final ModelPart headwear;
	private final ModelPart bone;
	private final ModelPart bone2;
	private final ModelPart bone3;

	public ChristmasHatModel() {
		textureWidth = 64;
		textureHeight = 64;
		headwear = new ModelPart(this);
		headwear.setPivot(5.0F, -9.0F, -5.0F);
		headwear.setTextureOffset(0, 0).addCuboid(-10.0F, -0.1F, 0.0F, 10.0F, 2.0F, 10.0F, 0.0F, false);

		bone = new ModelPart(this);
		bone.setPivot(-8.5F, -0.1F, 1.5F);
		headwear.addChild(bone);
		setRotationAngle(bone, -0.0524F, 0.0F, 0.0349F);
		bone.setTextureOffset(0, 12).addCuboid(0.0F, -4.0F, 0.0F, 7.0F, 4.0F, 7.0F, 0.0F, false);

		bone2 = new ModelPart(this);
		bone2.setPivot(1.5F, -4.0F, 1.5F);
		bone.addChild(bone2);
		setRotationAngle(bone2, -0.1222F, 0.0F, 0.0698F);
		bone2.setTextureOffset(0, 23).addCuboid(0.0F, -4.0F, 0.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);

		bone3 = new ModelPart(this);
		bone3.setPivot(1.5F, -4.0F, 1.5F);
		bone2.addChild(bone3);
		setRotationAngle(bone3, -0.2618F, 0.0F, 0.1047F);
		bone3.setTextureOffset(21, 12).addCuboid(0.0F, -3.0F, 0.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
	}

	@Override
	public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		headwear.render(matrixStack, buffer, packedLight, packedOverlay);
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