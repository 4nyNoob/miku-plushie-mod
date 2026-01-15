package com.any.mikuplushie.entity.client.model;

import com.any.mikuplushie.MikuPlushie;
import com.any.mikuplushie.entity.NeruEntity;
import com.any.mikuplushie.entity.client.model.animations.PlushAnimations;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class NeruModel extends GeoModel<NeruEntity> {
    private final String entity = "neru_plush";

    private final Identifier model = Identifier.of(MikuPlushie.MOD_ID, "geo/entity/" + entity + ".geo.json");
    private final Identifier animations = Identifier.of(MikuPlushie.MOD_ID, "animations/plush.animation.json");


    @Override
    public Identifier getModelResource(NeruEntity animatable) {
        return model;
    }

    @Override
    public Identifier getTextureResource(NeruEntity animatable) {
        return Identifier.of(MikuPlushie.MOD_ID, variantToBlockTextureName(animatable));
    }

    @Override
    public Identifier getAnimationResource(NeruEntity animatable) {
        return animations;
    }

    @Override
    public void setCustomAnimations(NeruEntity animatable, long instanceId, software.bernie.geckolib.animation.AnimationState<NeruEntity> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);
        PlushAnimations.limbAnimations(this, animatable, animationState);
        PlushAnimations.hairMovement(this, animatable, animationState);
    }

    private String variantToBlockTextureName (NeruEntity animatable) {
        return "textures/block/" + animatable.getVariant() + ".png";
    }
}
