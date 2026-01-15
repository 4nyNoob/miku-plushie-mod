package com.any.mikuplushie.entity.client.render;

import com.any.mikuplushie.entity.AikoEntity;
import com.any.mikuplushie.entity.KonohaEntity;
import com.any.mikuplushie.entity.client.model.KonohaModel;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.util.math.RotationAxis;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.BlockAndItemGeoLayer;

public class KonohaRender extends GeoEntityRenderer<KonohaEntity> {

    public static final String LEFT_HAND = "left_hand";
    public static final String RIGHT_HAND = "right_hand";

    protected ItemStack mainHandItem;
    protected ItemStack offHandItem;

    public KonohaRender(EntityRendererFactory.Context renderManager) {
        super(renderManager, new KonohaModel());

        // Add some held item rendering
        addRenderLayer(new BlockAndItemGeoLayer<>(this) {
            @Nullable
            public ItemStack getStackForBone(GeoBone bone, KonohaEntity animatable) {
                // Retrieve the items in the entity's hands for the relevant bone
                return switch (bone.getName()) {
                    case LEFT_HAND -> animatable.isLeftHanded() ?
                        KonohaRender.this.mainHandItem : KonohaRender.this.offHandItem;
                    case RIGHT_HAND -> animatable.isLeftHanded() ?
                        KonohaRender.this.offHandItem : KonohaRender.this.mainHandItem;
                    default -> null;
                };
            }

            public ModelTransformationMode getTransformTypeForStack(GeoBone bone, ItemStack stack, KonohaEntity animatable) {
                // Apply the camera transform for the given hand
                return switch (bone.getName()) {
                    case LEFT_HAND, RIGHT_HAND -> ModelTransformationMode.THIRD_PERSON_RIGHT_HAND;
                    default -> ModelTransformationMode.NONE;
                };
            }

            // Do some quick render modifications depending on what the item is
            public void renderStackForBone(MatrixStack poseStack, GeoBone bone, ItemStack stack, KonohaEntity animatable,
                                            VertexConsumerProvider bufferSource, float partialTick, int packedLight, int packedOverlay) {
                if (stack == KonohaRender.this.mainHandItem) {
                    poseStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-90f));

                    if (stack.getItem() instanceof ShieldItem)
                        poseStack.translate(0, 0.125, -0.25);
                }
                else if (stack == KonohaRender.this.offHandItem) {
                    poseStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-90f));

                    if (stack.getItem() instanceof ShieldItem) {
                        poseStack.translate(0, 0.125, 0.25);
                        poseStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180));
                    }
                }

                super.renderStackForBone(poseStack, bone, stack, animatable, bufferSource, partialTick, packedLight, packedOverlay);
            }
        });
    }

    @Override
    public void preRender(MatrixStack poseStack, KonohaEntity animatable, BakedGeoModel model, @Nullable VertexConsumerProvider bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, colour);
        this.mainHandItem = animatable.getMainHandStack();
        this.offHandItem = animatable.getOffHandStack();
    }
}
