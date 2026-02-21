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
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;
import software.bernie.geckolib.animation.state.BoneSnapshot;
import software.bernie.geckolib.cache.model.BakedGeoModel;
import software.bernie.geckolib.cache.model.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.constant.dataticket.DataTicket;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.base.BoneSnapshots;
import software.bernie.geckolib.renderer.base.GeoRenderState;
import software.bernie.geckolib.renderer.base.RenderPassInfo;
import software.bernie.geckolib.renderer.layer.builtin.BlockAndItemGeoLayer;
import software.bernie.geckolib.renderer.layer.builtin.CustomBoneTextureGeoLayer;
import software.bernie.geckolib.renderer.layer.builtin.ItemInHandGeoLayer;

import java.util.Optional;

public class AbstractPlushRender<R extends EntityRenderState & GeoRenderState> extends GeoEntityRenderer<AbstractPlushEntity, R> {

    public static final String LEFT_HAND = "left_hand";
    public static final String RIGHT_HAND = "right_hand";

    public AbstractPlushRender(EntityRendererProvider.Context context) {
        super(context, new AbstractPlushModel());

        withRenderLayer(new ItemInHandGeoLayer<>(this, LEFT_HAND, RIGHT_HAND));
    }

    @Override
    public void adjustModelBonesForRender(RenderPassInfo<R> renderPassInfo, BoneSnapshots snapshots) {
        super.adjustModelBonesForRender(renderPassInfo, snapshots);

        Float limbSwing = renderPassInfo.getGeckolibData(AbstractPlushModel.LIMB_SWING);
        Float swingAmm = renderPassInfo.getGeckolibData(AbstractPlushModel.LIMB_SWING_AMOUNT);

        Optional<BoneSnapshot> root = snapshots.get("root_offset");
        Optional<BoneSnapshot> left_leg = snapshots.get("left_leg_offset");
        Optional<BoneSnapshot> right_leg = snapshots.get("right_leg_offset");
        Optional<BoneSnapshot> left_arm = snapshots.get("left_arm_offset");
        Optional<BoneSnapshot> right_arm = snapshots.get("right_arm_offset");
        Optional<BoneSnapshot> body = snapshots.get("body_offset");

        Boolean busy = renderPassInfo.getGeckolibData(AbstractPlushModel.BUSY);

//        float limbSwing = state.getLimbSwing();
//        float swingAmm = state.getLimbSwingAmount();
        float toRad = (float) (Math.PI / 180);
        float swingSpeed = 1F;

        //GET BONES
//        GeoBone root = plush.getAnimationProcessor().getBone("root_offset");
//        GeoBone left_leg = plush.getAnimationProcessor().getBone("left_leg_offset");
//        GeoBone right_leg = plush.getAnimationProcessor().getBone("right_leg_offset");
//        GeoBone left_arm = plush.getAnimationProcessor().getBone("left_arm_offset");
//        GeoBone right_arm = plush.getAnimationProcessor().getBone("right_arm_offset");
//        GeoBone body = plush.getAnimationProcessor().getBone("body_offset");

        //HEALTH DISPLAY
/*        float maxHealth = animatable.getMaxHealth();
        float health = animatable.getHealth();*/
        Float healthFactor = renderPassInfo.getGeckolibData(AbstractPlushModel.HEALTH);
        int bendAmount = 25;
        float healthBend = ((healthFactor) - 1) * bendAmount;

        //ROOT ANIMATION
        root.get().setRotZ((float) Math.sin(limbSwing * swingSpeed) * (swingAmm * 5 * toRad));
        root.get().setTranslateY((float) Math.sin(limbSwing * swingSpeed * 2) * (swingAmm * 1) + (swingAmm * 1));

        //DISABLE ARM ANIMATIONS WHEN DANCING AND ATTACKING
        if (busy){
            left_arm.get().setRotX(0);
            right_arm.get().setRotX(0);
        } else {
            left_arm.get().setRotX((float) Math.sin(limbSwing * swingSpeed) * (swingAmm * 50 * toRad) - (healthBend * toRad));
            right_arm.get().setRotX((float) Math.sin(limbSwing * swingSpeed) * (swingAmm * -50 * toRad) - (healthBend * toRad));
        }
        //LEGS ANIMATION
        left_leg.get().setRotX((float) Math.sin(limbSwing * swingSpeed) * (swingAmm * -50 * toRad));
        right_leg.get().setRotX((float) Math.sin(limbSwing * swingSpeed) * (swingAmm * 50 * toRad));
        //BODY ANIMATION
        body.get().setRotX(healthBend * toRad);

        //HEAD ANIM
        Optional<BoneSnapshot> head = snapshots.get("head_offset");
//        GeoBone head = plush.getAnimationProcessor().getBone("head_offset");
        float headPitch = renderPassInfo.getGeckolibData(DataTickets.ENTITY_PITCH);
        float headYaw = renderPassInfo.getGeckolibData(DataTickets.ENTITY_YAW);
        head.get().setRotX((headPitch - healthBend) * toRad);
        head.get().setRotY(headYaw * toRad);
    }
}