package com.any.miku_plushie.entity;

import java.util.List;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animation.RawAnimation;

public class TetoEntity extends AbstractPlushEntity {

  public TetoEntity(EntityType<? extends TamableAnimal> entityType, Level world) {
    super(entityType, world);
  }

  //DANCE ANIMATIONS
  @Override
  public List<RawAnimation> getDances() {
    return List.of(
        RawAnimation.begin().thenLoop("misc.dance.generic.caramelldansen"),
        RawAnimation.begin().thenLoop("misc.dance.teto.teto-territory"),
        RawAnimation.begin().thenLoop("misc.dance.teto.birdbrain"),
        RawAnimation.begin().thenLoop("misc.dance.teto.liar-dancer")
    );
  }
}
