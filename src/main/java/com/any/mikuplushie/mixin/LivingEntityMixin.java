package com.any.mikuplushie.mixin;

import com.any.mikuplushie.ModSoundEvents;
import com.any.mikuplushie.datagen.ModTagProvider;
import net.minecraft.entity.Attackable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity implements Attackable {

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "playEquipmentBreakEffects", at = @At("HEAD"))
    private void handlePickaxeBreakSound(ItemStack stack, CallbackInfo ci){
        if (stack.isIn(ModTagProvider.TETO_PICKAXE)) {
//            if (!this.isSilent()) {
                this.getWorld().playSound(
                        this.getX(),
                        this.getY(),
                        this.getZ(),
                        ModSoundEvents.TETO_BYE,
                        this.getSoundCategory(),
                        0.8F,
                        1F,
                        false
                    )
                ;
//            }
        }
    }
}
