package com.any.mikuplushie.registry;

import com.any.mikuplushie.MikuPlushie;
import com.any.mikuplushie.entity.*;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
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


    public static List<EntityType<? extends AbstractPlushEntity>> PLUSH_ENTITIES = new ArrayList<>();

    public static final float PLUSH_WIDTH = 0.6F;
    public static final float PLUSH_HEIGHT = 1F;

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
        EntityType<T> entityType = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MikuPlushie.MOD_ID, name),
            EntityType.Builder.create(entity, SpawnGroup.CREATURE)
                .dimensions(PLUSH_WIDTH, PLUSH_HEIGHT)
                .eyeHeight(0.85F)
                .build(name)
        );
        //noinspection unchecked
        PLUSH_ENTITIES.add((EntityType<? extends AbstractPlushEntity>) entityType);
        return entityType;
    }

    public static void initialize(){
        MikuPlushie.LOGGER.info("Registering " + MikuPlushie.MOD_ID + " Entities");
        for (EntityType<? extends AbstractPlushEntity> entity : PLUSH_ENTITIES) {
            FabricDefaultAttributeRegistry.register(entity, AbstractPlushEntity.createAttributes());
        }
    }
}
