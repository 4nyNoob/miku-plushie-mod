package com.any.mikuplushie.entity.client;

import com.any.mikuplushie.MikuPlushie;
import com.any.mikuplushie.entity.MikuEntity;
import com.any.mikuplushie.entity.variant.MikuVariant;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class MikuModel extends GeoModel<MikuEntity> {
    private final String entity = "miku_plush";

    private final Identifier model = Identifier.of(MikuPlushie.MOD_ID, "geo/entity/" + entity + ".geo.json");
    private final Identifier texture = Identifier.of(MikuPlushie.MOD_ID, "textures/block/" + entity.replace('_', '-') + ".png");
    private final Identifier animations = Identifier.of(MikuPlushie.MOD_ID, "animations/" + entity + ".animation.json");


    @Override
    public Identifier getModelResource(MikuEntity animatable) {
        MikuVariant variant = animatable.getVariant();
        if (
            variant.equals(MikuVariant.MIKU_PLUSH_MUSHROOM) ||
            variant.equals(MikuVariant.MIKU_PLUSH_WEREWOMAN) ||
            variant.equals(MikuVariant.MIKU_PLUSH_PATATI) ||
            variant.equals(MikuVariant.MIKU_PLUSH_PATATA) ||
            variant.equals(MikuVariant.MIKU_PLUSH_DEVIL) ||
            variant.equals(MikuVariant.MIKU_PLUSH_WITCH)) {
            return Identifier.of(MikuPlushie.MOD_ID, "geo/entity/" + entity + "_2" + ".geo.json");
        }
        else if (
            variant.equals(MikuVariant.MIKU_PLUSH_XMAS_TREE) ||
            variant.equals(MikuVariant.MIKU_PLUSH_SONIC) ||
            variant.equals(MikuVariant.MIKU_PLUSH_DIGITAL_STARS_2025) ||
            variant.equals(MikuVariant.MIKU_PLUSH_ROTTEN_GIRL) ||
            variant.equals(MikuVariant.MIKU_PLUSH_PSYCHO_MODE) ||
            variant.equals(MikuVariant.MIKU_PLUSH_DONT_BELIEVE_IN_T) ||
            variant.equals(MikuVariant.MIKU_PLUSH_STATIC) ||
            variant.equals(MikuVariant.MIKU_PLUSH_MOCHIMOCHI) ||
            variant.equals(MikuVariant.MIKU_PLUSH_MONITORING)
        ) {
            return Identifier.of(MikuPlushie.MOD_ID, "geo/entity/" + entity + "_3" + ".geo.json");
        } else {
            return model;
        }
    }

    @Override
    public Identifier getTextureResource(MikuEntity animatable) {
//        String variantName = animatable.getVariant().name().toLowerCase().replace('_', '-');
        String variantName = animatable.getVariant().getBlock().replace('_', '-');
        String textureFile = "textures/block/" + variantName + ".png";
        return Identifier.of(MikuPlushie.MOD_ID, textureFile);
//        return texture;
    }

    @Override
    public Identifier getAnimationResource(MikuEntity animatable) {
        return animations;
    }

    @Override
    public void setCustomAnimations(MikuEntity animatable, long instanceId, AnimationState<MikuEntity> state) {
        super.setCustomAnimations(animatable, instanceId, state);

        CoreGeoBone head = this.getAnimationProcessor().getBone("head_offset");
        CoreGeoBone hair = this.getAnimationProcessor().getBone("hair_offset");
        CoreGeoBone longerHair = this.getAnimationProcessor().getBone("longer_hair_offset");
        float headPitch = state.getData(DataTickets.ENTITY_MODEL_DATA).headPitch();
        float headYaw = state.getData(DataTickets.ENTITY_MODEL_DATA).netHeadYaw();
        if (head != null) {
            head.setRotX(headPitch * ((float) Math.PI / 180F));
            head.setRotY(headYaw * ((float) Math.PI / 180F));
            hair.setRotX(-headPitch * ((float) Math.PI / 180F));
            longerHair.setRotX(-headPitch * ((float) Math.PI / 180F));
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

        hair.setRotZ((float) Math.sin(limbSwing * swingSpeed - (45/20F)) * (swingAmm * -10 * toRad));

    }
}
