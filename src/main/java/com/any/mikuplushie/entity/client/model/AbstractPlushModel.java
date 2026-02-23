package com.any.mikuplushie.entity.client.model;

import com.any.mikuplushie.MikuPlushie;
import com.any.mikuplushie.entity.AbstractPlushEntity;
import com.any.mikuplushie.registry.ModBlocks;
import com.any.mikuplushie.util.ModUtil;
import com.google.common.reflect.TypeToken;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import software.bernie.geckolib.constant.dataticket.DataTicket;
import software.bernie.geckolib.model.DefaultedGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.base.GeoRenderState;

import java.util.Objects;

public class AbstractPlushModel extends GeoModel<AbstractPlushEntity> {

    //    private final Identifier model = Identifier.of(MikuPlushie.MOD_ID, "geo/entity/" + entity + ".geo.json");


    public static final DataTicket<String> NAME = DataTicket.create("name", String.class, new TypeToken<>(){});
    public static final DataTicket<String> VARIATION = DataTicket.create("variation", String.class, new TypeToken<>(){});
    public static final DataTicket<Float> LIMB_SWING = DataTicket.create("limb_swing", Float.class, new TypeToken<>(){});
    public static final DataTicket<Float> LIMB_SWING_AMOUNT = DataTicket.create("limb_swing_amount", Float.class, new TypeToken<>(){});
    public static final DataTicket<Boolean> BUSY = DataTicket.create("busy", Boolean.class, new TypeToken<>(){});
    public static final DataTicket<Float> HEALTH = DataTicket.create("health", Float.class, new TypeToken<>(){});


    @Override
    public Identifier getModelResource(GeoRenderState renderState) {
        String entity = renderState.getGeckolibData(NAME);
        String variant = renderState.getGeckolibData(VARIATION);

        if (variant.equals(entity)){
            return Identifier.fromNamespaceAndPath(MikuPlushie.MOD_ID, entity);
        }
        //VARIANTS THAT USE THE 2ND MODEL
        else if (
            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_MUSHROOM)) ||
            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_WEREWOMAN)) ||
            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_PATATI)) ||
            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_PATATA)) ||
            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_DEVIL)) ||
            variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_WITCH))) {
            return Identifier.fromNamespaceAndPath(MikuPlushie.MOD_ID, entity + "_2");
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
            return Identifier.fromNamespaceAndPath(MikuPlushie.MOD_ID, entity + "_3");
        }
        return Identifier.fromNamespaceAndPath(MikuPlushie.MOD_ID, entity);
    }

    @Override
    public @NonNull Identifier getTextureResource(GeoRenderState renderState) {
        return Identifier.fromNamespaceAndPath(MikuPlushie.MOD_ID, variantToBlockTextureName(Objects.requireNonNull(renderState.getGeckolibData(VARIATION))));
    }

    @Override
    public @NonNull Identifier getAnimationResource(AbstractPlushEntity animatable) {
        return Identifier.fromNamespaceAndPath(MikuPlushie.MOD_ID, "plush");
    }

    private String variantToBlockTextureName (String variant) {
        return "textures/block/" + variant.replace('_', '-') + ".png";
    }

    @Override
    public void addAdditionalStateData(AbstractPlushEntity animatable, @Nullable Object relatedObject, GeoRenderState renderState) {
        super.addAdditionalStateData(animatable, relatedObject, renderState);
        renderState.addGeckolibData(NAME, animatable.getPlushName());
        renderState.addGeckolibData(VARIATION, animatable.getVariant());;
        renderState.addGeckolibData(LIMB_SWING, animatable.walkAnimation.position());
        renderState.addGeckolibData(LIMB_SWING_AMOUNT, animatable.walkAnimation.speed(renderState.getPartialTick()));
        renderState.addGeckolibData(BUSY, animatable.isSongPlaying() || animatable.swinging);
        renderState.addGeckolibData(HEALTH, animatable.getHealth() / animatable.getMaxHealth());
    }
}
