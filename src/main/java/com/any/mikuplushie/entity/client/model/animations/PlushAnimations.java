package com.any.mikuplushie.entity.client.model.animations;

import com.any.mikuplushie.entity.AbstractPlushEntity;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class PlushAnimations {

    public static void limbAnimations(GeoModel<?> plush, AbstractPlushEntity animatable, AnimationState<?> state){

        //LIMB ANIM VARIABLES
        float limbSwing = state.getLimbSwing();
        float swingAmm = state.getLimbSwingAmount();
        float toRad = (float) (Math.PI / 180);
        float swingSpeed = 1F;

        //GET BONES
        CoreGeoBone root = plush.getAnimationProcessor().getBone("root_offset");
        CoreGeoBone left_leg = plush.getAnimationProcessor().getBone("left_leg_offset");
        CoreGeoBone right_leg = plush.getAnimationProcessor().getBone("right_leg_offset");
        CoreGeoBone left_arm = plush.getAnimationProcessor().getBone("left_arm_offset");
        CoreGeoBone right_arm = plush.getAnimationProcessor().getBone("right_arm_offset");

        //ANIM CODE
        root.setRotZ((float) Math.sin(limbSwing * swingSpeed) * (swingAmm * 5 * toRad));
        root.setPosY((float) Math.sin(limbSwing * swingSpeed * 2) * (swingAmm * 1) + (swingAmm * 1));

        //DISABLE ARM ANIMATIONS WHEN DANCING AND ATTACKING
        if (animatable.isSongPlaying() || animatable.handSwinging){
            left_arm.setRotX(0);
            right_arm.setRotX(0);
        } else {
            left_arm.setRotX((float) Math.sin(limbSwing * swingSpeed) * (swingAmm * 50 * toRad));
            right_arm.setRotX((float) Math.sin(limbSwing * swingSpeed) * (swingAmm * -50 * toRad));
        }

        left_leg.setRotX((float) Math.sin(limbSwing * swingSpeed) * (swingAmm * -50 * toRad));
        right_leg.setRotX((float) Math.sin(limbSwing * swingSpeed) * (swingAmm * 50 * toRad));
    }

    public static void headLook(GeoModel<?> plush, AbstractPlushEntity animatable, AnimationState<?> state){
        CoreGeoBone head = plush.getAnimationProcessor().getBone("head_offset");
        float headPitch = state.getData(DataTickets.ENTITY_MODEL_DATA).headPitch();
        float headYaw = state.getData(DataTickets.ENTITY_MODEL_DATA).netHeadYaw();
        head.setRotX(headPitch * ((float) Math.PI / 180F));
        head.setRotY(headYaw * ((float) Math.PI / 180F));
    }

    public static void hairMovement(GeoModel<?> plush, AbstractPlushEntity animatable, AnimationState<?> state){
        //ANIM VARIABLES
        float limbSwing = state.getLimbSwing();
        float swingAmm = state.getLimbSwingAmount();
        float toRad = (float) (Math.PI / 180);
        float swingSpeed = 1F;

        CoreGeoBone hair = plush.getAnimationProcessor().getBone("hair_offset");
        float headPitch = state.getData(DataTickets.ENTITY_MODEL_DATA).headPitch();

        hair.setRotX(-headPitch * ((float) Math.PI / 180F));
        hair.setRotZ((float) Math.sin(limbSwing * swingSpeed - (45/20F)) * (swingAmm * -10 * toRad));
    }

}
