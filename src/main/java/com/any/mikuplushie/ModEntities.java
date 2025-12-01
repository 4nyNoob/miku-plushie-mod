package com.any.mikuplushie;

import com.any.mikuplushie.commands.SpawnMikusCommand;
import com.any.mikuplushie.entity.*;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import software.bernie.example.entity.BatEntity;
import software.bernie.example.registry.EntityRegistry;
import software.bernie.geckolib.GeckoLib;

public class ModEntities {


    private static final float PLUSH_WIDTH = 0.6F;
    private static final float PLUSH_HEIGHT = 0.8F;

    public static final EntityType<MikuEntity> MIKU =
        Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MikuPlushie.MOD_ID, "miku_plush"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MikuEntity::new)
                .dimensions(EntityDimensions.fixed(PLUSH_WIDTH, PLUSH_HEIGHT)).build());

    public static final EntityType<TetoEntity> TETO =
        Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MikuPlushie.MOD_ID, "teto_plush"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, TetoEntity::new)
                .dimensions(EntityDimensions.fixed(PLUSH_WIDTH, PLUSH_HEIGHT)).build());

    public static final EntityType<AikoEntity> AIKO =
        Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MikuPlushie.MOD_ID, "aiko_plush"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, AikoEntity::new)
                .dimensions(EntityDimensions.fixed(PLUSH_WIDTH, PLUSH_HEIGHT)).build());

    public static final EntityType<NeruEntity> NERU =
        Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MikuPlushie.MOD_ID, "neru_plush"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, NeruEntity::new)
                .dimensions(EntityDimensions.fixed(PLUSH_WIDTH, PLUSH_HEIGHT)).build());

    public static final EntityType<RinEntity> RIN =
        Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MikuPlushie.MOD_ID, "rin_plush"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RinEntity::new)
                .dimensions(EntityDimensions.fixed(PLUSH_WIDTH, PLUSH_HEIGHT)).build());

    public static final EntityType<LenEntity> LEN =
        Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MikuPlushie.MOD_ID, "len_plush"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, LenEntity::new)
                .dimensions(EntityDimensions.fixed(PLUSH_WIDTH, PLUSH_HEIGHT)).build());

    public static final EntityType<KonohaEntity> KONOHA =
        Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MikuPlushie.MOD_ID, "konoha_plush"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, KonohaEntity::new)
                .dimensions(EntityDimensions.fixed(PLUSH_WIDTH, PLUSH_HEIGHT)).build());

    public static final EntityType<LukaEntity> LUKA =
        Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MikuPlushie.MOD_ID, "luka_plush"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, LukaEntity::new)
                .dimensions(EntityDimensions.fixed(PLUSH_WIDTH, PLUSH_HEIGHT)).build());

    public static final EntityType<MeikoEntity> MEIKO =
        Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MikuPlushie.MOD_ID, "meiko_plush"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MeikoEntity::new)
                .dimensions(EntityDimensions.fixed(PLUSH_WIDTH, PLUSH_HEIGHT)).build());

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
    }
}
