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
import java.util.ArrayList;
import java.util.List;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class ModEntities {


  public static final float PLUSH_WIDTH = 0.6F;
  public static final float PLUSH_HEIGHT = 1F;
  public static List<EntityType<? extends AbstractPlushEntity>> PLUSH_ENTITIES = new ArrayList<>();
  public static final EntityType<MikuEntity> MIKU = registerMob("miku_plush", MikuEntity::new);
  public static final EntityType<TetoEntity> TETO = registerMob("teto_plush", TetoEntity::new);
  public static final EntityType<AikoEntity> AIKO = registerMob("aiko_plush", AikoEntity::new);
  public static final EntityType<NeruEntity> NERU = registerMob("akita_neru_plush", NeruEntity::new);
  public static final EntityType<RinEntity> RIN = registerMob("rin_plush", RinEntity::new);
  public static final EntityType<LenEntity> LEN = registerMob("len_plush", LenEntity::new);
  public static final EntityType<KonohaEntity> KONOHA = registerMob("konoha_plush", KonohaEntity::new);
  public static final EntityType<LukaEntity> LUKA = registerMob("luka_plush", LukaEntity::new);
  public static final EntityType<MeikoEntity> MEIKO = registerMob("meiko_plush", MeikoEntity::new);
  public static final EntityType<GumiEntity> GUMI = registerMob("gumi_plush", GumiEntity::new);
  public static final EntityType<KaitoEntity> KAITO = registerMob("kaito_plush", KaitoEntity::new);


  private static <T extends Entity> EntityType<T> registerMob(String name, EntityType.EntityFactory<T> entity) {
    EntityType<T> entityType = Registry.register(BuiltInRegistries.ENTITY_TYPE,
        ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name),
        EntityType.Builder.of(entity, MobCategory.CREATURE)
            .sized(PLUSH_WIDTH, PLUSH_HEIGHT)
            .eyeHeight(0.85F)
            .build(name)
    );
    //noinspection unchecked
    PLUSH_ENTITIES.add((EntityType<? extends AbstractPlushEntity>) entityType);
    return entityType;
  }

  public static void initialize() {
    MikuPlushieFabric.LOGGER.info("Registering " + Constants.MOD_ID + " Entities");
    for (EntityType<? extends AbstractPlushEntity> entity : PLUSH_ENTITIES) {
      FabricDefaultAttributeRegistry.register(entity, AbstractPlushEntity.createAttributes());
    }
  }
}
