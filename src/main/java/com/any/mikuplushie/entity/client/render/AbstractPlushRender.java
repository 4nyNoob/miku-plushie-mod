package com.any.mikuplushie.entity.client.render;

import com.any.mikuplushie.entity.AbstractPlushEntity;
import com.any.mikuplushie.entity.client.model.AbstractPlushModel;
import com.any.mikuplushie.entity.client.model.animations.PlushAnimations;
import com.any.mikuplushie.registry.ModBlocks;
import com.any.mikuplushie.util.ModUtil;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.base.BoneSnapshots;
import software.bernie.geckolib.renderer.base.RenderPassInfo;
import software.bernie.geckolib.renderer.layer.builtin.ItemInHandGeoLayer;

public class AbstractPlushRender extends GeoEntityRenderer<AbstractPlushEntity, PlushRenderState> {
    public AbstractPlushRender(EntityRendererFactory.Context context) {
        super(context, new AbstractPlushModel());
        withRenderLayer(new ItemInHandGeoLayer<>(this, "right_hand", "left_hand"));
    }

    @Override
    public PlushRenderState createRenderState(AbstractPlushEntity entity, Void relatedObject) {
        return new PlushRenderState();
    }

    @Override
    public void captureDefaultRenderState(AbstractPlushEntity entity, Void relatedObject, PlushRenderState state, float tickDelta) {
        super.captureDefaultRenderState(entity, relatedObject, state, tickDelta);
        state.plushName = entity.getPlushName();
        state.variant = entity.getVariant();
        state.dancing = entity.isSongPlaying();
        state.attacking = entity.handSwinging;
        state.healthRatio = entity.getHealth() / entity.getMaxHealth();
    }

    @Override
    public RenderLayer getRenderType(PlushRenderState state, Identifier texture) {
        if (state.variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.MIKU_PLUSH_GHOST)) ||
            state.variant.equals(ModUtil.getBlockIdFromBlock(ModBlocks.TETO_PLUSH_WHATCHACALLITSNAME))) {
            return RenderLayers.entityTranslucent(texture);
        }
        return super.getRenderType(state, texture);
    }

    @Override
    public void adjustModelBonesForRender(RenderPassInfo<PlushRenderState> pass, BoneSnapshots bones) {
        PlushAnimations.apply(bones, pass.renderState());
    }
}
