package com.any.mikuplushie.entity.client.render;

import com.any.mikuplushie.entity.AbstractPlushEntity;
import com.any.mikuplushie.entity.TetoEntity;
import com.any.mikuplushie.entity.client.model.AbstractPlushModel;
import com.any.mikuplushie.registry.ModBlocks;
import com.any.mikuplushie.util.ModUtil;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.BlockAndItemGeoLayer;

public class AbstractPlushRender extends GeoEntityRenderer<AbstractPlushEntity> {

    public static final String LEFT_HAND = "left_hand";
    public static final String RIGHT_HAND = "right_hand";

    protected ItemStack mainHandItem;
    protected ItemStack offHandItem;

    public AbstractPlushRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new AbstractPlushModel());

        // Add some held item rendering
        addRenderLayer(new BlockAndItemGeoLayer<>(this) {
            @Nullable
            public ItemStack getStackForBone(GeoBone bone, AbstractPlushEntity animatable) {
                // Retrieve the items in the entity's hands for the relevant bone
                return switch (bone.getName()) {
                    case LEFT_HAND -> animatable.isLeftHanded() ?
                        AbstractPlushRender.this.mainHandItem : AbstractPlushRender.this.offHandItem;
                    case RIGHT_HAND -> animatable.isLeftHanded() ?
                        AbstractPlushRender.this.offHandItem : AbstractPlushRender.this.mainHandItem;
                    default -> null;
                };
            }

            public ItemDisplayContext getTransformTypeForStack(GeoBone bone, ItemStack stack, AbstractPlushEntity animatable) {
                // Apply the camera transform for the given hand
                return switch (bone.getName()) {
                    case LEFT_HAND, RIGHT_HAND -> ItemDisplayContext.THIRD_PERSON_RIGHT_HAND;
                    default -> ItemDisplayContext.NONE;
                };
            }

            // Do some quick render modifications depending on what the item is
            public void renderStackForBone(PoseStack poseStack, GeoBone bone, ItemStack stack, AbstractPlushEntity animatable,
                                            MultiBufferSource bufferSource, float partialTick, int packedLight, int packedOverlay) {
                if (stack == AbstractPlushRender.this.mainHandItem) {
                    poseStack.mulPose(Axis.XP.rotationDegrees(-90f));

                    if (stack.getItem() instanceof ShieldItem)
                        poseStack.translate(0, 0.125, -0.25);
                }
                else if (stack == AbstractPlushRender.this.offHandItem) {
                    poseStack.mulPose(Axis.XP.rotationDegrees(-90f));

                    if (stack.getItem() instanceof ShieldItem) {
                        poseStack.translate(0, 0.125, 0.25);
                        poseStack.mulPose(Axis.YP.rotationDegrees(180));
                    }
                }

                super.renderStackForBone(poseStack, bone, stack, animatable, bufferSource, partialTick, packedLight, packedOverlay);
            }
        });
    }

    @Override
    public RenderType getRenderType(AbstractPlushEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        //USE TRANSLUCENT RENDER ON SPECIFIC VARIATION
        if (
            animatable.getVariant().equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_GHOST)) ||
            animatable.getVariant().equals(ModUtil.getBlockIdFromBlock(ModBlocks.TETO_PLUSH_WHATCHACALLITSNAME))
        ){
            return RenderType.entityTranslucent(texture);
        } else {
            return super.getRenderType(animatable, texture, bufferSource, partialTick);
        }
    }

    @Override
    public void preRender(PoseStack poseStack, AbstractPlushEntity animatable, BakedGeoModel model, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, colour);
        this.mainHandItem = animatable.getMainHandItem();
        this.offHandItem = animatable.getOffhandItem();
    }
}
