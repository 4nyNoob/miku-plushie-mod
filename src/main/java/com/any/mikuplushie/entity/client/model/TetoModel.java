package com.any.mikuplushie.entity.client.model;

import com.any.mikuplushie.MikuPlushie;
import com.any.mikuplushie.entity.TetoEntity;
import com.any.mikuplushie.entity.client.model.animations.PlushAnimations;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class TetoModel extends GeoModel<TetoEntity> {
    private final String entity = "teto_plush";

    private final Identifier model = Identifier.of(MikuPlushie.MOD_ID, "geo/entity/" + entity + ".geo.json");
    private final Identifier animations = Identifier.of(MikuPlushie.MOD_ID, "animations/plush.animation.json");


    @Override
    public Identifier getModelResource(TetoEntity animatable) {
            return model;
    }

    @Override
    public Identifier getTextureResource(TetoEntity animatable) {
        return Identifier.of(MikuPlushie.MOD_ID, variantToBlockTextureName(animatable));
    }

    @Override
    public Identifier getAnimationResource(TetoEntity animatable) {
        return animations;
    }

    @Override
    public void setCustomAnimations(TetoEntity animatable, long instanceId, software.bernie.geckolib.animation.AnimationState<TetoEntity> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);
        PlushAnimations.limbAnimations(this, animatable, animationState);
        PlushAnimations.hairMovement(this, animatable, animationState);
    }

    private String variantToBlockTextureName (TetoEntity animatable) {
        return "textures/block/" + animatable.getVariant().replace('_', '-') + ".png";
    }
}
