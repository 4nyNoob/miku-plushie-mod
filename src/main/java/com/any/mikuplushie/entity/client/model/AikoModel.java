package com.any.mikuplushie.entity.client.model;

import com.any.mikuplushie.MikuPlushie;
import com.any.mikuplushie.entity.AikoEntity;
import com.any.mikuplushie.entity.client.model.animations.PlushAnimations;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class AikoModel extends GeoModel<AikoEntity> {
    private final String entity = "aiko_plush";

    private final Identifier model = Identifier.of(MikuPlushie.MOD_ID, "geo/entity/" + entity + ".geo.json");
    private final Identifier animations = Identifier.of(MikuPlushie.MOD_ID, "animations/plush.animation.json");


    @Override
    public Identifier getModelResource(AikoEntity animatable) {
        return model;
    }

    @Override
    public Identifier getTextureResource(AikoEntity animatable) {
        return Identifier.of(MikuPlushie.MOD_ID, variantToBlockTextureName(animatable));
    }

    @Override
    public Identifier getAnimationResource(AikoEntity animatable) {
        return animations;
    }

    @Override
    public void setCustomAnimations(AikoEntity animatable, long instanceId, AnimationState<AikoEntity> state) {
        super.setCustomAnimations(animatable, instanceId, state);
        PlushAnimations.headLook(this, animatable, state);
        PlushAnimations.limbAnimations(this, animatable, state);
    }

    private String variantToBlockTextureName (AikoEntity animatable) {
        return "textures/block/" + animatable.getVariant().replace('_', '-') + ".png";
    }
}
