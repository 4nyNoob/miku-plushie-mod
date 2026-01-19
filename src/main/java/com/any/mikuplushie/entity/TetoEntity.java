package com.any.mikuplushie.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.world.World;
import software.bernie.geckolib.core.animation.RawAnimation;

import java.util.List;

public class TetoEntity extends AbstractPlushEntity {

    public TetoEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
    }

    //DANCE ANIMATIONS
    @Override
    public List<RawAnimation> getDances(){
        return  List.of(
            RawAnimation.begin().thenLoop("misc.dance.generic.caramelldansen"),
            RawAnimation.begin().thenLoop("misc.dance.teto.teto-territory"),
            RawAnimation.begin().thenLoop("misc.dance.teto.birdbrain"),
            RawAnimation.begin().thenLoop("misc.dance.teto.liar-dancer")
        );
    }
}
