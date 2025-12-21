package com.any.mikuplushie.registry;

import com.any.mikuplushie.MikuPlushie;
import com.any.mikuplushie.entity.*;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class ModEntities {


    private static final float PLUSH_WIDTH = 0.6F;
    private static final float PLUSH_HEIGHT = 0.8F;

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


    public static <T extends MobEntity> EntityType<T> registerMob(String name, EntityType.EntityFactory<T> entity) {
        return Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MikuPlushie.MOD_ID, name), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, entity)
                .dimensions(EntityDimensions.fixed(PLUSH_WIDTH, PLUSH_HEIGHT)).build());
    }

    public static void initialize(){
        MikuPlushie.LOGGER.info("Registering " + MikuPlushie.MOD_ID + " Entities");

        FabricDefaultAttributeRegistry.register(MIKU, MikuEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(TETO, TetoEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(AIKO, AikoEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(NERU, NeruEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(RIN, RinEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(LEN, LenEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(KONOHA, KonohaEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(LUKA, LukaEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(MEIKO, MeikoEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(GUMI, GumiEntity.createAttributes());
    }
}
