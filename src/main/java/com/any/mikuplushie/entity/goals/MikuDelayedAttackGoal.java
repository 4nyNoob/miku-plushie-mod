package com.any.mikuplushie.entity.goals;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

public class MikuDelayedAttackGoal extends MeleeAttackGoal {
    private int attackDelay = 5;
    private LivingEntity target;
    private boolean mikuAttacking;

    public MikuDelayedAttackGoal(PathfinderMob mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
    }
    /**
     *   Swing the entity hand but handle the actual attack on the {@link #tick()} method
     */
    @Override
    protected void checkAndPerformAttack(LivingEntity target) {
        if (this.canPerformAttack(target)) {
            this.resetAttackCooldown();
            this.mob.swing(InteractionHand.MAIN_HAND);
            this.target = target;
            this.mikuAttacking = true;
        }
    }
    /**
     *   Receive the attack command but wait 5 ticks to execute it, then reset
     */
    @Override
    public void tick() {
        if (this.mikuAttacking){
            --this.attackDelay;
            if (this.attackDelay <= 0){
                this.mob.doHurtTarget(this.target);
                this.mikuAttacking = false;
            }
        } else {
            this.attackDelay = 5;
        }
        super.tick();
    }
}
