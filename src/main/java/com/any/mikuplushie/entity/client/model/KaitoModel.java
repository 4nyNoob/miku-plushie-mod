package com.any.mikuplushie.entity.client.model;

import com.any.mikuplushie.MikuPlushie;
import com.any.mikuplushie.entity.KaitoEntity;
import com.any.mikuplushie.entity.client.model.animations.PlushAnimations;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class KaitoModel extends GeoModel<KaitoEntity> {
    private final String entity = "kaito_plush";

    private final Identifier model = Identifier.of(MikuPlushie.MOD_ID, "geo/entity/" + entity + ".geo.json");
    private final Identifier animations = Identifier.of(MikuPlushie.MOD_ID, "animations/plush.animation.json");


    @Override
    public Identifier getModelResource(KaitoEntity animatable) {
        return model;
    }

    @Override
    public Identifier getTextureResource(KaitoEntity animatable) {
        return Identifier.of(MikuPlushie.MOD_ID, variantToBlockTextureName(animatable));
    }

    @Override
    public Identifier getAnimationResource(KaitoEntity animatable) {
        return animations;
    }

    @Override
    public void setCustomAnimations(KaitoEntity animatable, long instanceId, software.bernie.geckolib.animation.AnimationState<KaitoEntity> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);
        PlushAnimations.limbAnimations(this, animatable, animationState);
    }

    private String variantToBlockTextureName (KaitoEntity animatable) {
        return "textures/block/" + animatable.getVariant().replace('_', '-') + ".png";
    }
}
