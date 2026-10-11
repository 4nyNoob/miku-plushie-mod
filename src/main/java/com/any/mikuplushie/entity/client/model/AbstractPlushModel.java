package com.any.mikuplushie.entity.client.model;

import com.any.mikuplushie.MikuPlushie;
import com.any.mikuplushie.entity.AbstractPlushEntity;
import com.any.mikuplushie.entity.client.model.animations.PlushAnimations;
import com.any.mikuplushie.registry.ModBlocks;
import com.any.mikuplushie.util.ModUtil;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.base.GeoRenderState;
import com.any.mikuplushie.entity.client.render.PlushRenderState;
import software.bernie.geckolib.model.GeoModel;

public class AbstractPlushModel extends GeoModel<AbstractPlushEntity> {

    //    private final Identifier model = Identifier.of(MikuPlushie.MOD_ID, "entity/" + entity);
    private final Identifier animations = Identifier.of(MikuPlushie.MOD_ID, "plush");


    @Override
    public Identifier getModelResource(GeoRenderState renderState) {

        PlushRenderState state = (PlushRenderState) renderState;
        String entity = state.plushName;
        String variant = state.variant;

        if (variant.equals(entity)){
            return Identifier.of(MikuPlushie.MOD_ID, "entity/" + entity);
        }
        //VARIANTS THAT USE THE 2ND MODEL
        else if (
            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_MUSHROOM)) ||
            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_WEREWOMAN)) ||
            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_PATATI)) ||
            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_PATATA)) ||
            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_DEVIL)) ||
            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_WITCH))) {
            return Identifier.of(MikuPlushie.MOD_ID, "entity/" + entity + "_2");
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
            return Identifier.of(MikuPlushie.MOD_ID, "entity/" + entity + "_3");
        }
        return Identifier.of(MikuPlushie.MOD_ID, "entity/" + entity);
    }

    @Override
    public Identifier getTextureResource(GeoRenderState renderState) {
        return Identifier.of(MikuPlushie.MOD_ID, "textures/block/" + ((PlushRenderState) renderState).variant.replace('_', '-') + ".png");
    }

    @Override
    public Identifier getAnimationResource(AbstractPlushEntity animatable) {
        return animations;
    }

}
