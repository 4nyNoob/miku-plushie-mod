package com.any.mikuplushie.entity.client.model;

import com.any.mikuplushie.MikuPlushie;
import com.any.mikuplushie.entity.MikuEntity;
import com.any.mikuplushie.entity.client.model.animations.PlushAnimations;
import com.any.mikuplushie.entity.variant.MikuVariant;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class MikuModel extends GeoModel<MikuEntity> {
    private final String entity = "miku_plush";

    private final Identifier model = Identifier.of(MikuPlushie.MOD_ID, "geo/entity/" + entity + ".geo.json");
    private final Identifier animations = Identifier.of(MikuPlushie.MOD_ID, "animations/plush.animation.json");


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
            variant.equals(MikuVariant.MIKU_PLUSH_HORNET.getBlock()) ||
            variant.equals(MikuVariant.MIKU_PLUSH_LUCARIO_Z.getBlock())
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
        PlushAnimations.hairMovement(this, animatable, state);
        PlushAnimations.limbAnimations(this, animatable, state);
    }

    private String variantToBlockTextureName (MikuEntity animatable) {
        return "textures/block/" + animatable.getVariant().replace('_', '-') + ".png";
    }
}
