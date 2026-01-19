package com.any.mikuplushie.entity.client.render;

import com.any.mikuplushie.entity.MikuEntity;
import com.any.mikuplushie.entity.TetoEntity;
import com.any.mikuplushie.entity.client.model.TetoModel;
import com.any.mikuplushie.registry.ModBlocks;
import com.any.mikuplushie.util.ModUtil;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.BlockAndItemGeoLayer;

public class TetoRender extends GeoEntityRenderer<TetoEntity> {

    public static final String LEFT_HAND = "left_hand";
    public static final String RIGHT_HAND = "right_hand";

    protected ItemStack mainHandItem;
    protected ItemStack offHandItem;

    public TetoRender(EntityRendererFactory.Context renderManager) {
        super(renderManager, new TetoModel());

        // Add some held item rendering
        addRenderLayer(new BlockAndItemGeoLayer<>(this) {
            @Nullable
            public ItemStack getStackForBone(GeoBone bone, TetoEntity animatable) {
                // Retrieve the items in the entity's hands for the relevant bone
                return switch (bone.getName()) {
                    case LEFT_HAND -> animatable.isLeftHanded() ?
                        TetoRender.this.mainHandItem : TetoRender.this.offHandItem;
                    case RIGHT_HAND -> animatable.isLeftHanded() ?
                        TetoRender.this.offHandItem : TetoRender.this.mainHandItem;
                    default -> null;
                };
            }

            public ModelTransformationMode getTransformTypeForStack(GeoBone bone, ItemStack stack, TetoEntity animatable) {
                // Apply the camera transform for the given hand
                return switch (bone.getName()) {
                    case LEFT_HAND, RIGHT_HAND -> ModelTransformationMode.THIRD_PERSON_RIGHT_HAND;
                    default -> ModelTransformationMode.NONE;
                };
            }

            // Do some quick render modifications depending on what the item is
            public void renderStackForBone(MatrixStack poseStack, GeoBone bone, ItemStack stack, TetoEntity animatable,
                                            VertexConsumerProvider bufferSource, float partialTick, int packedLight, int packedOverlay) {
                if (stack == TetoRender.this.mainHandItem) {
                    poseStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-90f));

                    if (stack.getItem() instanceof ShieldItem)
                        poseStack.translate(0, 0.125, -0.25);
                }
                else if (stack == TetoRender.this.offHandItem) {
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
    public RenderLayer getRenderType(TetoEntity animatable, Identifier texture, VertexConsumerProvider bufferSource, float partialTick) {
        //USE TRANSLUCENT RENDER ON SPECIFIC VARIATION
        if (animatable.getVariant().equals(ModUtil.getBlockIdFromBlock(ModBlocks.TETO_PLUSH_WHATCHACALLITSNAME))){
            return RenderLayer.getEntityTranslucent(texture);
        } else {
            return super.getRenderType(animatable, texture, bufferSource, partialTick);
        }
    }

    @Override
    public void preRender(MatrixStack poseStack, TetoEntity animatable, BakedGeoModel model, @Nullable VertexConsumerProvider bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, colour);
        this.mainHandItem = animatable.getMainHandStack();
        this.offHandItem = animatable.getOffHandStack();
    }
}
