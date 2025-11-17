package com.any.mikuplushie;

import com.any.mikuplushie.commands.SpawnMikusCommand;
import com.any.mikuplushie.entity.AikoEntity;
import com.any.mikuplushie.entity.MikuEntity;
import com.any.mikuplushie.entity.TetoEntity;
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

    public static final EntityType<MikuEntity> MIKU =
        Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MikuPlushie.MOD_ID, "miku_plush"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MikuEntity::new)
                .dimensions(EntityDimensions.fixed(0.8F, 0.8F)).build());

    public static final EntityType<TetoEntity> TETO =
        Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MikuPlushie.MOD_ID, "teto_plush"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, TetoEntity::new)
                .dimensions(EntityDimensions.fixed(0.8F, 0.8F)).build());

    public static final EntityType<AikoEntity> AIKO =
        Registry.register(Registries.ENTITY_TYPE,
            new Identifier(MikuPlushie.MOD_ID, "aiko_plush"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, AikoEntity::new)
                .dimensions(EntityDimensions.fixed(0.8F, 0.8F)).build());

    public static void initialize(){
        MikuPlushie.LOGGER.info("Registering " + MikuPlushie.MOD_ID + " Entities");

        FabricDefaultAttributeRegistry.register(MIKU, MikuEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(TETO, TetoEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(AIKO, AikoEntity.createAttributes());
    }
}
