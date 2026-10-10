package com.any.miku_plushie.impl.common.registry;

import com.any.miku_plushie.Constants;
import com.any.miku_plushie.MikuPlushie;
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
import net.minecraft.world.entity.MobCategory;

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

    Constants.LOG.info("Registering " + Constants.MOD_ID + " Entities");

    ModEntities.MIKU = registerPlushieMob("miku_plush", MikuEntity::new, consumer);
    ModEntities.TETO = registerPlushieMob("teto_plush", TetoEntity::new, consumer);
    ModEntities.AIKO = registerPlushieMob("aiko_plush", AikoEntity::new, consumer);
    ModEntities.NERU = registerPlushieMob("akita_neru_plush", NeruEntity::new, consumer);
    ModEntities.RIN = registerPlushieMob("rin_plush", RinEntity::new, consumer);
    ModEntities.LEN = registerPlushieMob("len_plush", LenEntity::new, consumer);
    ModEntities.KONOHA = registerPlushieMob("konoha_plush", KonohaEntity::new, consumer);
    ModEntities.LUKA = registerPlushieMob("luka_plush", LukaEntity::new, consumer);
    ModEntities.MEIKO = registerPlushieMob("meiko_plush", MeikoEntity::new, consumer);
    ModEntities.GUMI = registerPlushieMob("gumi_plush", GumiEntity::new, consumer);
    ModEntities.KAITO = registerPlushieMob("kaito_plush", KaitoEntity::new, consumer);
  }

  private static <T extends AbstractPlushEntity> EntityType<T> registerPlushieMob(String name, EntityType.EntityFactory<T> entity, BiConsumer<EntityType<?>, ResourceLocation> consumer) {

    ResourceLocation id = MikuPlushie.id(name);
    EntityType<T> entityType = EntityType.Builder.<T>of(entity, MobCategory.CREATURE)
        .sized(ModEntities.PLUSH_WIDTH, ModEntities.PLUSH_HEIGHT)
        .eyeHeight(0.85F)
        .build(id.toString());


    // doesn't need a noinspection comment now, bc this method is only used to register
    // entities of this type :p
    ModEntities.PLUSH_ENTITIES.add((EntityType<? extends AbstractPlushEntity>) entityType);

    consumer.accept(entityType, id);

    return entityType;
  }
}
