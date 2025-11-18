package com.any.mikuplushie.entity.client.model;

import com.any.mikuplushie.MikuPlushie;
import com.any.mikuplushie.entity.LenEntity;
import com.any.mikuplushie.entity.RinEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class LenModel extends GeoModel<LenEntity> {
    private final String entity = "len_plush";

    private final Identifier model = Identifier.of(MikuPlushie.MOD_ID, "geo/entity/" + entity + ".geo.json");
    private final Identifier texture = Identifier.of(MikuPlushie.MOD_ID, "textures/block/" + entity.replace('_', '-') + ".png");
//    private final Identifier animations = Identifier.of(MikuPlushie.MOD_ID, "animations/" + entity + ".animation.json");
    private final Identifier animations = Identifier.of(MikuPlushie.MOD_ID, "animations/aiko_plush.animation.json");


    @Override
    public Identifier getModelResource(LenEntity animatable) {
        return model;
    }

    @Override
    public Identifier getTextureResource(LenEntity animatable) {
        return texture;
    }

    @Override
    public Identifier getAnimationResource(LenEntity animatable) {
        return animations;
    }

    @Override
    public void setCustomAnimations(LenEntity animatable, long instanceId, AnimationState<LenEntity> state) {
        super.setCustomAnimations(animatable, instanceId, state);

        CoreGeoBone head = this.getAnimationProcessor().getBone("head_offset");
        float headPitch = state.getData(DataTickets.ENTITY_MODEL_DATA).headPitch();
        float headYaw = state.getData(DataTickets.ENTITY_MODEL_DATA).netHeadYaw();
        if (head != null) {
            head.setRotX(headPitch * ((float) Math.PI / 180F));
            head.setRotY(headYaw * ((float) Math.PI / 180F));
        }

        //ANIMATION DEBUG
        //float limbSwing = (float) state.getAnimationTick() / 2;
        //float swingAmm = 1;

        //ANIM VARIABLES
        float limbSwing = state.getLimbSwing();
        float swingAmm = state.getLimbSwingAmount();
        float toRad = (float) (Math.PI / 180);
        float swingSpeed = 1F;

        //GET BONES
        CoreGeoBone root = this.getAnimationProcessor().getBone("root_offset");
        CoreGeoBone left_leg = this.getAnimationProcessor().getBone("left_leg_offset");
        CoreGeoBone right_leg = this.getAnimationProcessor().getBone("right_leg_offset");
        CoreGeoBone left_arm = this.getAnimationProcessor().getBone("left_arm_offset");
        CoreGeoBone right_arm = this.getAnimationProcessor().getBone("right_arm_offset");

        //ANIM CODE
        root.setRotZ((float) Math.sin(limbSwing * swingSpeed) * (swingAmm * 5 * toRad));
        root.setPosY((float) Math.sin(limbSwing * swingSpeed * 2) * (swingAmm * 1) + (swingAmm * 1));

        left_leg.setRotX((float) Math.sin(limbSwing * swingSpeed) * (swingAmm * -50 * toRad));
        right_leg.setRotX((float) Math.sin(limbSwing * swingSpeed) * (swingAmm * 50 * toRad));
        left_arm.setRotX((float) Math.sin(limbSwing * swingSpeed) * (swingAmm * 50 * toRad));
        right_arm.setRotX((float) Math.sin(limbSwing * swingSpeed) * (swingAmm * -50 * toRad));

    }

}
