package com.any.mikuplushie.entity.client.model;

import com.any.mikuplushie.MikuPlushie;
import com.any.mikuplushie.entity.MeikoEntity;
import com.any.mikuplushie.entity.client.model.animations.PlushAnimations;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class MeikoModel extends GeoModel<MeikoEntity> {
    private final String entity = "meiko_plush";

    private final Identifier model = Identifier.of(MikuPlushie.MOD_ID, "geo/entity/" + entity + ".geo.json");
    private final Identifier animations = Identifier.of(MikuPlushie.MOD_ID, "animations/plush.animation.json");


    @Override
    public Identifier getModelResource(MeikoEntity animatable) {
            return model;
    }

    @Override
    public Identifier getTextureResource(MeikoEntity animatable) {
        return Identifier.of(MikuPlushie.MOD_ID, variantToBlockTextureName(animatable));
    }

    @Override
    public Identifier getAnimationResource(MeikoEntity animatable) {
        return animations;
    }

    @Override
    public void setCustomAnimations(MeikoEntity animatable, long instanceId, software.bernie.geckolib.animation.AnimationState<MeikoEntity> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);
        PlushAnimations.limbAnimations(this, animatable, animationState);
    }

    private String variantToBlockTextureName (MeikoEntity animatable) {
        return "textures/block/" + animatable.getVariant().replace('_', '-') + ".png";
    }
}
