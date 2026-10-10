package com.any.mikuplushie.entity.client.model;

import com.any.mikuplushie.MikuPlushie;
import com.any.mikuplushie.entity.AbstractPlushEntity;
import com.any.mikuplushie.entity.client.model.animations.PlushAnimations;
import com.any.mikuplushie.registry.ModBlocks;
import com.any.mikuplushie.util.ModUtil;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class AbstractPlushModel extends GeoModel<AbstractPlushEntity> {

    //    private final Identifier model = Identifier.of(MikuPlushie.MOD_ID, "geo/entity/" + entity + ".geo.json");
    private final ResourceLocation animations = ResourceLocation.fromNamespaceAndPath(MikuPlushie.MOD_ID, "animations/plush.animation.json");


    @Override
    public ResourceLocation getModelResource(AbstractPlushEntity animatable) {

        String entity = animatable.getPlushName();
        String variant = animatable.getVariant();

        if (variant.equals(animatable.getPlushName())){
            return ResourceLocation.fromNamespaceAndPath(MikuPlushie.MOD_ID, "geo/entity/" + entity + ".geo.json");
        }
        //VARIANTS THAT USE THE 2ND MODEL
        else if (
            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_MUSHROOM)) ||
            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_WEREWOMAN)) ||
            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_PATATI)) ||
            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_PATATA)) ||
            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_DEVIL)) ||
            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_WITCH))) {
            return ResourceLocation.fromNamespaceAndPath(MikuPlushie.MOD_ID, "geo/entity/" + entity + "_2" + ".geo.json");
        }
        //VARIANTS THAT USE THE 3RD MODEL
        else if (
            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_XMAS_TREE)) ||
            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_SONIC)) ||
            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_DIGITAL_STARS_2025)) ||
            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_ROTTEN_GIRL)) ||
            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_PSYCHO_MODE)) ||
            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_DONT_BELIEVE_IN_T)) ||
            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_STATIC)) ||
            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_MOCHIMOCHI)) ||
            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_MONITORING)) ||
            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_HOLLOW_KNIGHT)) ||
            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_HORNET)) ||
            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_LUCARIO_Z))||
            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_PPPP))
        ) {
            return ResourceLocation.fromNamespaceAndPath(MikuPlushie.MOD_ID, "geo/entity/" + entity + "_3" + ".geo.json");
        }
        return ResourceLocation.fromNamespaceAndPath(MikuPlushie.MOD_ID, "geo/entity/" + entity + ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AbstractPlushEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(MikuPlushie.MOD_ID, variantToBlockTextureName(animatable));
    }

    @Override
    public ResourceLocation getAnimationResource(AbstractPlushEntity animatable) {
        return animations;
    }

    @Override
    public void setCustomAnimations(AbstractPlushEntity animatable, long instanceId, AnimationState<AbstractPlushEntity> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);
        if (
            animatable.getPlushName().contains("miku") ||
            animatable.getPlushName().contains("teto") ||
            animatable.getPlushName().contains("neru")
        ) {
            PlushAnimations.hairMovement(this, animatable, animationState);
        }
        PlushAnimations.limbAnimations(this, animatable, animationState);
    }

    private String variantToBlockTextureName (AbstractPlushEntity animatable) {
        return "textures/block/" + animatable.getVariant().replace('_', '-') + ".png";
    }
}
