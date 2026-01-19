package com.any.mikuplushie.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.world.World;
import software.bernie.geckolib.core.animation.RawAnimation;

import java.util.List;

public class NeruEntity extends AbstractPlushEntity {

    public NeruEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
    }

    //DANCE ANIMATIONS
    @Override
    public List<RawAnimation> getDances() {
        return List.of(
            RawAnimation.begin().thenLoop("misc.dance.generic.caramelldansen"),
            RawAnimation.begin().thenLoop("misc.dance.miku.ievan-polkka"),
            RawAnimation.begin().thenLoop("misc.dance.miku.vegetable-juice")
        );
    }
}
