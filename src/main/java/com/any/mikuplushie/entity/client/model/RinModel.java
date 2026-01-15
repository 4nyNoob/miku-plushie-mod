package com.any.mikuplushie.entity.client.model;

import com.any.mikuplushie.MikuPlushie;
import com.any.mikuplushie.entity.AikoEntity;
import com.any.mikuplushie.entity.RinEntity;
import com.any.mikuplushie.entity.client.model.animations.PlushAnimations;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class RinModel extends GeoModel<RinEntity> {
    private final String entity = "rin_plush";

    private final Identifier model = Identifier.of(MikuPlushie.MOD_ID, "geo/entity/" + entity + ".geo.json");
    private final Identifier animations = Identifier.of(MikuPlushie.MOD_ID, "animations/plush.animation.json");


    @Override
    public Identifier getModelResource(RinEntity animatable) {
        return model;
    }

    @Override
    public Identifier getTextureResource(RinEntity animatable) {
        return Identifier.of(MikuPlushie.MOD_ID, variantToBlockTextureName(animatable));
    }

    @Override
    public Identifier getAnimationResource(RinEntity animatable) {
        return animations;
    }

    @Override
    public void setCustomAnimations(RinEntity animatable, long instanceId, AnimationState<RinEntity> state) {
        super.setCustomAnimations(animatable, instanceId, state);
        PlushAnimations.limbAnimations(this, animatable, state);
    }

    private String variantToBlockTextureName (RinEntity animatable) {
        return "textures/block/" + animatable.getVariant().replace('_', '-') + ".png";
    }
}
