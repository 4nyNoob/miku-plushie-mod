package com.any.mikuplushie.entity.goals;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.Hand;

public class MikuDelayedAttackGoal extends MeleeAttackGoal {
    private int attackDelay = 5;
    private LivingEntity target;
    private boolean mikuAttacking;

    public MikuDelayedAttackGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
    }
    /**
     *   Swing the entity hand but handle the actual attack on the {@link #tick()} method
     */
    @Override
    protected void attack(LivingEntity target) {
        if (this.canAttack(target)) {
            this.resetCooldown();
            this.mob.swingHand(Hand.MAIN_HAND);
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
                this.mob.tryAttack(this.target);
                this.mikuAttacking = false;
            }
        } else {
            this.attackDelay = 5;
        }
        super.tick();
    }
}
