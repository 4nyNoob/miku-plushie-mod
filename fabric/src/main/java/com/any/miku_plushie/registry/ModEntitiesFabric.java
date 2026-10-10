package com.any.miku_plushie.registry;

import com.any.miku_plushie.Constants;
import com.any.miku_plushie.MikuPlushieFabric;
import com.any.miku_plushie.entity.AbstractPlushEntity;
import com.any.miku_plushie.entity.AikoEntity;
import com.any.miku_plushie.entity.GumiEntity;
import com.any.miku_plushie.entity.KaitoEntity;
import com.any.miku_plushie.entity.KonohaEntity;
import com.any.miku_plushie.entity.LenEntity;
import com.any.miku_plushie.entity.LukaEntity;
import com.any.miku_plushie.entity.MeikoEntity;
import com.any.miku_plushie.entity.MikuEntity;
import com.any.miku_plushie.entity.NeruEntity;
import com.any.miku_plushie.entity.RinEntity;
import com.any.miku_plushie.entity.TetoEntity;
import com.any.miku_plushie.impl.common.registry.ModEntities;
import java.util.ArrayList;
import java.util.List;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class ModEntitiesFabric {

  /// hm TODO extends AbstractPlushEntity
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

  private static <T extends Entity> EntityType<T> registerMob(String name, EntityType.EntityFactory<T> entity) {
    EntityType<T> entityType = Registry.register(BuiltInRegistries.ENTITY_TYPE,
        ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name),
        EntityType.Builder.of(entity, MobCategory.CREATURE)
            .sized(ModEntities.PLUSH_WIDTH, ModEntities.PLUSH_HEIGHT)
            .eyeHeight(0.85F)
            .build(name)
    );
    //noinspection unchecked
    PLUSH_ENTITIES.add((EntityType<? extends AbstractPlushEntity>) entityType);
    return entityType;
  }

  public static void initialize() {
    MikuPlushieFabric.LOGGER.info("Registering " + Constants.MOD_ID + " Entities");

    MIKU = registerMob("miku_plush", MikuEntity::new);
    TETO = registerMob("teto_plush", TetoEntity::new);
    AIKO = registerMob("aiko_plush", AikoEntity::new);
    NERU = registerMob("akita_neru_plush", NeruEntity::new);
    RIN = registerMob("rin_plush", RinEntity::new);
    LEN = registerMob("len_plush", LenEntity::new);
    KONOHA = registerMob("konoha_plush", KonohaEntity::new);
    LUKA = registerMob("luka_plush", LukaEntity::new);
    MEIKO = registerMob("meiko_plush", MeikoEntity::new);
    GUMI = registerMob("gumi_plush", GumiEntity::new);
    KAITO = registerMob("kaito_plush", KaitoEntity::new);
  }
}
