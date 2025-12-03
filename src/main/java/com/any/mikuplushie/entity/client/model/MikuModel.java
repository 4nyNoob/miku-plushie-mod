package com.any.mikuplushie.entity.client.model;

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
        String variant = animatable.getVariant();
        //VARIANTS THAT USE THE 2ND MODEL
        if (
            variant.equals(MikuVariant.MIKU_PLUSH_MUSHROOM.getBlock()) ||
            variant.equals(MikuVariant.MIKU_PLUSH_WEREWOMAN.getBlock()) ||
            variant.equals(MikuVariant.MIKU_PLUSH_PATATI.getBlock()) ||
            variant.equals(MikuVariant.MIKU_PLUSH_PATATA.getBlock()) ||
            variant.equals(MikuVariant.MIKU_PLUSH_DEVIL.getBlock()) ||
            variant.equals(MikuVariant.MIKU_PLUSH_WITCH.getBlock())) {
            return Identifier.of(MikuPlushie.MOD_ID, "geo/entity/" + entity + "_2" + ".geo.json");
        }
        //VARIANTS THAT USE THE 3RD MODEL
        else if (
            variant.equals(MikuVariant.MIKU_PLUSH_XMAS_TREE.getBlock()) ||
            variant.equals(MikuVariant.MIKU_PLUSH_SONIC.getBlock()) ||
            variant.equals(MikuVariant.MIKU_PLUSH_DIGITAL_STARS_2025.getBlock()) ||
            variant.equals(MikuVariant.MIKU_PLUSH_ROTTEN_GIRL.getBlock()) ||
            variant.equals(MikuVariant.MIKU_PLUSH_PSYCHO_MODE.getBlock()) ||
            variant.equals(MikuVariant.MIKU_PLUSH_DONT_BELIEVE_IN_T.getBlock()) ||
            variant.equals(MikuVariant.MIKU_PLUSH_STATIC.getBlock()) ||
            variant.equals(MikuVariant.MIKU_PLUSH_MOCHIMOCHI.getBlock()) ||
            variant.equals(MikuVariant.MIKU_PLUSH_MONITORING.getBlock()) ||
            variant.equals(MikuVariant.MIKU_PLUSH_HOLLOW_KNIGHT.getBlock()) ||
            variant.equals(MikuVariant.MIKU_PLUSH_HORNET.getBlock())
        ) {
            return Identifier.of(MikuPlushie.MOD_ID, "geo/entity/" + entity + "_3" + ".geo.json");
        }
        //DEFAULT MODEL
        else {
            return model;
        }
    }

    @Override
    public Identifier getTextureResource(MikuEntity animatable) {
        return Identifier.of(MikuPlushie.MOD_ID, variantToBlockTextureName(animatable));
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
        if (!animatable.handSwinging) {
            left_arm.setRotX((float) Math.sin(limbSwing * swingSpeed) * (swingAmm * 50 * toRad));
            right_arm.setRotX((float) Math.sin(limbSwing * swingSpeed) * (swingAmm * -50 * toRad));
        } else {
            left_arm.setRotX(0);
            right_arm.setRotX(0);
        }
        hair.setRotZ((float) Math.sin(limbSwing * swingSpeed - (45/20F)) * (swingAmm * -10 * toRad));
    }

    private String variantToBlockTextureName (MikuEntity animatable) {
        return "textures/block/" + animatable.getVariant().replace('_', '-') + ".png";
    }
}
