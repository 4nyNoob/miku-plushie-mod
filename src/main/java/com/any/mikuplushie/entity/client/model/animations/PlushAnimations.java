package com.any.mikuplushie.entity.client.model.animations;

import com.any.mikuplushie.entity.client.render.PlushRenderState;
import software.bernie.geckolib.renderer.base.BoneSnapshots;

public class PlushAnimations {
    public static void apply(BoneSnapshots bones, PlushRenderState state) {
        float swing = state.limbSwingAnimationProgress;
        float amount = state.limbSwingAmplitude;
        float rad = (float) (Math.PI / 180);
        float healthBend = (state.healthRatio - 1) * 25;
        bones.ifPresent("root_offset", b -> b.setRotZ((float) Math.sin(swing) * amount * 5 * rad));
        bones.ifPresent("root_offset", b -> b.setTranslateY((float) Math.sin(swing * 2) * amount + amount));
        bones.ifPresent("left_arm_offset", b -> b.setRotX(state.dancing || state.attacking ? 0 : (float) Math.sin(swing) * amount * 50 * rad - healthBend * rad));
        bones.ifPresent("right_arm_offset", b -> b.setRotX(state.dancing || state.attacking ? 0 : (float) Math.sin(swing) * amount * -50 * rad - healthBend * rad));
        bones.ifPresent("left_leg_offset", b -> b.setRotX((float) Math.sin(swing) * amount * -50 * rad));
        bones.ifPresent("right_leg_offset", b -> b.setRotX((float) Math.sin(swing) * amount * 50 * rad));
        bones.ifPresent("body_offset", b -> b.setRotX(healthBend * rad));
        bones.ifPresent("head_offset", b -> b.setRotX((state.pitch - healthBend) * rad).setRotY(state.relativeHeadYaw * rad));
        if (state.plushName.contains("miku") || state.plushName.contains("teto") || state.plushName.contains("neru")) {
            bones.ifPresent("hair_offset", b -> b.setRotX(-state.pitch * rad).setRotZ((float) Math.sin(swing - 45 / 20F) * amount * -10 * rad));
        }
    }
}
