package com.any.miku_plushie.impl.common.registry;

import com.any.miku_plushie.impl.common.entity.AbstractPlushEntity;
import com.any.miku_plushie.impl.common.entity.AikoEntity;
import com.any.miku_plushie.impl.common.entity.GumiEntity;
import com.any.miku_plushie.impl.common.entity.KaitoEntity;
import com.any.miku_plushie.impl.common.entity.KonohaEntity;
import com.any.miku_plushie.impl.common.entity.LenEntity;
import com.any.miku_plushie.impl.common.entity.LukaEntity;
import com.any.miku_plushie.impl.common.entity.MeikoEntity;
import com.any.miku_plushie.impl.common.entity.MikuEntity;
import com.any.miku_plushie.impl.common.entity.NeruEntity;
import com.any.miku_plushie.impl.common.entity.RinEntity;
import com.any.miku_plushie.impl.common.entity.TetoEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;

public class ModEntities {

  public static final float PLUSH_WIDTH = 0.6F;
  public static final float PLUSH_HEIGHT = 1F;

  public static final List<EntityType<? extends AbstractPlushEntity>> PLUSH_ENTITIES = new ArrayList<>();
  
  public static EntityType<MikuEntity> MIKU;
  public static EntityType<TetoEntity> TETO;
  public static EntityType<AikoEntity> AIKO;
  public static EntityType<NeruEntity> NERU;
  public static EntityType<RinEntity> RIN;
  public static EntityType<LenEntity> LEN;
  public static EntityType<KonohaEntity> KONOHA;
  public static EntityType<LukaEntity> LUKA;
  public static EntityType<MeikoEntity> MEIKO;
  public static EntityType<GumiEntity> GUMI;
  public static EntityType<KaitoEntity> KAITO;

  public static void register(BiConsumer<EntityType<?>, ResourceLocation> consumer) {
  }
}
