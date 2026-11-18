package com.any.miku_plushie.impl.client.model;

import com.any.miku_plushie.Constants;
import com.any.miku_plushie.MikuPlushie;
import com.any.miku_plushie.impl.common.entity.AbstractPlushEntity;
import com.any.miku_plushie.impl.client.model.animations.PlushAnimations;
import com.any.miku_plushie.impl.common.registry.ModBlocks;
import com.any.miku_plushie.impl.common.util.ModUtil;
import com.geckolib.constant.DataTickets;
import com.geckolib.constant.dataticket.DataTicket;
import com.geckolib.model.GeoModel;
import com.geckolib.renderer.base.GeoRenderState;
import net.minecraft.resources.Identifier;

public class AbstractPlushModel extends GeoModel<AbstractPlushEntity> {

  //    private final Identifier model = Identifier.of(MikuPlushieFabric.MOD_ID, "geo/entity/" + entity + ".geo.json");
  private final Identifier animations = MikuPlushie.id("animations/plush.animation.json");

//TODO REWORK RENDERER

//  @Override
//  public Identifier getModelResource(GeoRenderState animatable) {
//
//    String entity = animatable.getPlushName();
//    String variant = animatable.getVariant();
//
//    if (variant.equals(animatable.getPlushName())) {
//      return MikuPlushie.id("geo/entity/" + entity + ".geo.json");
//    }
//    //VARIANTS THAT USE THE 2ND MODEL
//    else if (
//        variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_MUSHROOM)) ||
//            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_WEREWOMAN)) ||
//            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_PATATI)) ||
//            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_PATATA)) ||
//            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_DEVIL)) ||
//            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_WITCH))) {
//      return MikuPlushie.id("geo/entity/" + entity + "_2" + ".geo.json");
//    }
//    //VARIANTS THAT USE THE 3RD MODEL
//    else if (
//        variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_XMAS_TREE)) ||
//            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_SONIC)) ||
//            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_DIGITAL_STARS_2025)) ||
//            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_ROTTEN_GIRL)) ||
//            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_PSYCHO_MODE)) ||
//            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_DONT_BELIEVE_IN_T)) ||
//            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_STATIC)) ||
//            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_MOCHIMOCHI)) ||
//            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_MONITORING)) ||
//            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_HOLLOW_KNIGHT)) ||
//            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_HORNET)) ||
//            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_LUCARIO_Z)) ||
//            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_PPPP))
//    ) {
//      return MikuPlushie.id("geo/entity/" + entity + "_3" + ".geo.json");
//    }
//    return MikuPlushie.id("geo/entity/" + entity + ".geo.json");
//  }

//  @Override
//  public Identifier getTextureResource(GeoRenderState animatable) {
//    return MikuPlushie.id(variantToBlockTextureName(animatable.getGeckolibData(DataTickets.ANIMATABLE_CLASS)));
//  }


  @Override
  public Identifier getTextureResource(GeoRenderState renderState) {
    return MikuPlushie.id("textures/block/miku-plush.png");
  }

  @Override
  public Identifier getModelResource(GeoRenderState renderState) {
    return MikuPlushie.id("geo/entity/miku_plush.geo.json");
  }

//  @Override
//  public Identifier getTextureResource(GeoRenderState renderState) {
//    return null;
//  }

  @Override
  public Identifier getAnimationResource(AbstractPlushEntity animatable) {
    return animations;
  }

//  @Override
//  public void setCustomAnimations(AbstractPlushEntity animatable, long instanceId, AnimationState<AbstractPlushEntity> animationState) {
//    super.setCustomAnimations(animatable, instanceId, animationState);
//    if (
//        animatable.getPlushName().contains("miku") ||
//            animatable.getPlushName().contains("teto") ||
//            animatable.getPlushName().contains("neru")
//    ) {
//      PlushAnimations.hairMovement(this, animatable, animationState);
//    }
//    PlushAnimations.limbAnimations(this, animatable, animationState);
//  }

  private String variantToBlockTextureName(AbstractPlushEntity animatable) {
    return "textures/block/" + animatable.getVariant().replace('_', '-') + ".png";
  }
}
