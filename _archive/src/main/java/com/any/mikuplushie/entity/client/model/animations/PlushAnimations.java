package com.any.mikuplushie.entity.client.model.animations;

import com.any.mikuplushie.entity.AbstractPlushEntity;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.model.GeoModel;

public class PlushAnimations {

    public static void limbAnimations(GeoModel<?> plush, AbstractPlushEntity animatable, software.bernie.geckolib.animation.AnimationState<?> state){
        //LIMB ANIM VARIABLES
        float limbSwing = state.getLimbSwing();
        float swingAmm = state.getLimbSwingAmount();
        float toRad = (float) (Math.PI / 180);
        float swingSpeed = 1F;

        //GET BONES
        GeoBone root = plush.getAnimationProcessor().getBone("root_offset");
        GeoBone left_leg = plush.getAnimationProcessor().getBone("left_leg_offset");
        GeoBone right_leg = plush.getAnimationProcessor().getBone("right_leg_offset");
        GeoBone left_arm = plush.getAnimationProcessor().getBone("left_arm_offset");
        GeoBone right_arm = plush.getAnimationProcessor().getBone("right_arm_offset");
        GeoBone body = plush.getAnimationProcessor().getBone("body_offset");

        //HEALTH DISPLAY
        float maxHealth = animatable.getMaxHealth();
        float health = animatable.getHealth();
        float healthFactor = health / maxHealth;
        int bendAmount = 25;
        float healthBend = ((healthFactor) - 1) * bendAmount;

        //ROOT ANIMATION
        root.setRotZ((float) Math.sin(limbSwing * swingSpeed) * (swingAmm * 5 * toRad));
        root.setPosY((float) Math.sin(limbSwing * swingSpeed * 2) * (swingAmm * 1) + (swingAmm * 1));

        //DISABLE ARM ANIMATIONS WHEN DANCING AND ATTACKING
        if (animatable.isSongPlaying() || animatable.swinging){
            left_arm.setRotX(0);
            right_arm.setRotX(0);
        } else {
            left_arm.setRotX((float) Math.sin(limbSwing * swingSpeed) * (swingAmm * 50 * toRad) - (healthBend * toRad));
            right_arm.setRotX((float) Math.sin(limbSwing * swingSpeed) * (swingAmm * -50 * toRad) - (healthBend * toRad));
        }
        //LEGS ANIMATION
        left_leg.setRotX((float) Math.sin(limbSwing * swingSpeed) * (swingAmm * -50 * toRad));
        right_leg.setRotX((float) Math.sin(limbSwing * swingSpeed) * (swingAmm * 50 * toRad));
        //BODY ANIMATION
        body.setRotX(healthBend * toRad);

        //HEAD ANIM
        GeoBone head = plush.getAnimationProcessor().getBone("head_offset");
        float headPitch = state.getData(DataTickets.ENTITY_MODEL_DATA).headPitch();
        float headYaw = state.getData(DataTickets.ENTITY_MODEL_DATA).netHeadYaw();
        head.setRotX((headPitch - healthBend) * toRad);
        head.setRotY(headYaw * toRad);
    }

    public static void hairMovement(GeoModel<?> plush, AbstractPlushEntity animatable, software.bernie.geckolib.animation.AnimationState<?> state){
        //ANIM VARIABLES
        float limbSwing = state.getLimbSwing();
        float swingAmm = state.getLimbSwingAmount();
        float toRad = (float) (Math.PI / 180);
        float swingSpeed = 1F;

        GeoBone hair = plush.getAnimationProcessor().getBone("hair_offset");
        float headPitch = state.getData(DataTickets.ENTITY_MODEL_DATA).headPitch();

        hair.setRotX(-headPitch * ((float) Math.PI / 180F));
        hair.setRotZ((float) Math.sin(limbSwing * swingSpeed - (45/20F)) * (swingAmm * -10 * toRad));
    }

}
