package com.any.mikuplushie.entity;

import software.bernie.geckolib.animation.RawAnimation;

import java.util.List;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.Level;

public class NeruEntity extends AbstractPlushEntity {

    public NeruEntity(EntityType<? extends TamableAnimal> entityType, Level world) {
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
