package com.any.mikuplushie.entity.client.model;

import com.any.mikuplushie.MikuPlushie;
import com.any.mikuplushie.entity.LenEntity;
import com.any.mikuplushie.entity.RinEntity;
import com.any.mikuplushie.entity.client.model.animations.PlushAnimations;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class LenModel extends GeoModel<LenEntity> {
    private final String entity = "len_plush";

    private final Identifier model = Identifier.of(MikuPlushie.MOD_ID, "geo/entity/" + entity + ".geo.json");
    private final Identifier animations = Identifier.of(MikuPlushie.MOD_ID, "animations/plush.animation.json");


    @Override
    public Identifier getModelResource(LenEntity animatable) {
        return model;
    }

    @Override
    public Identifier getTextureResource(LenEntity animatable) {
        return Identifier.of(MikuPlushie.MOD_ID, variantToBlockTextureName(animatable));
    }

    @Override
    public Identifier getAnimationResource(LenEntity animatable) {
        return animations;
    }

    @Override
    public void setCustomAnimations(LenEntity animatable, long instanceId, AnimationState<LenEntity> state) {
        super.setCustomAnimations(animatable, instanceId, state);
        PlushAnimations.headLook(this, animatable, state);
        PlushAnimations.limbAnimations(this, animatable, state);
    }

    private String variantToBlockTextureName (LenEntity animatable) {
        return "textures/block/" + animatable.getVariant().replace('_', '-') + ".png";
    }
}
