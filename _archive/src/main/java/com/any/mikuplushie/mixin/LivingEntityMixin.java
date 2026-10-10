package com.any.mikuplushie.mixin;

import com.any.mikuplushie.registry.ModItems;
import com.any.mikuplushie.util.ModUtil;
import net.minecraft.world.entity.Attackable;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity implements Attackable {

    public LivingEntityMixin(EntityType<?> type, Level world) {
        super(type, world);
    }

    @Inject(method = "breakItem", at = @At("HEAD"))
    private void handlePickaxeBreakSound(ItemStack stack, CallbackInfo ci){
        if (ModItems.PICKAXE_ITEMS.contains(stack.getItem())) {
            if (!this.isSilent()) {
                this.level().playLocalSound(
                    this.getX(),
                    this.getY(),
                    this.getZ(),
                    ModUtil.getPlushSoundEvent("teto_plush", "bye"),
                    this.getSoundSource(),
                    0.8F,
                    1F,
                    false
                );
            }
        }
    }
}
