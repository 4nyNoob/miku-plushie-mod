package com.any.miku_plushie.registry;

import com.any.miku_plushie.Constants;
import com.any.miku_plushie.MikuPlushieFabric;
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
import com.any.miku_plushie.impl.common.registry.ModEntities;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class ModEntitiesFabric {

  private static <T extends Entity> EntityType<T> registerMob(String name, EntityType.EntityFactory<T> entity) {
    EntityType<T> entityType = Registry.register(BuiltInRegistries.ENTITY_TYPE,
        ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name),
        EntityType.Builder.of(entity, MobCategory.CREATURE)
            .sized(ModEntities.PLUSH_WIDTH, ModEntities.PLUSH_HEIGHT)
            .eyeHeight(0.85F)
            .build(name)
    );
    //noinspection unchecked
    ModEntities.PLUSH_ENTITIES.add((EntityType<? extends AbstractPlushEntity>) entityType);
    return entityType;
  }

  public static void initialize() {
    MikuPlushieFabric.LOGGER.info("Registering " + Constants.MOD_ID + " Entities");

    ModEntities.MIKU = registerMob("miku_plush", MikuEntity::new);
    ModEntities.TETO = registerMob("teto_plush", TetoEntity::new);
    ModEntities.AIKO = registerMob("aiko_plush", AikoEntity::new);
    ModEntities.NERU = registerMob("akita_neru_plush", NeruEntity::new);
    ModEntities.RIN = registerMob("rin_plush", RinEntity::new);
    ModEntities.LEN = registerMob("len_plush", LenEntity::new);
    ModEntities.KONOHA = registerMob("konoha_plush", KonohaEntity::new);
    ModEntities.LUKA = registerMob("luka_plush", LukaEntity::new);
    ModEntities.MEIKO = registerMob("meiko_plush", MeikoEntity::new);
    ModEntities.GUMI = registerMob("gumi_plush", GumiEntity::new);
    ModEntities.KAITO = registerMob("kaito_plush", KaitoEntity::new);
  }
}
