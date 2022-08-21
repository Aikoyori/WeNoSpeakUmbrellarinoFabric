package xyz.aikoyori.wenospeakumbrellarino.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Slice;
import xyz.aikoyori.wenospeakumbrellarino.Wenospeakumbrellarino;

@Mixin(LivingEntity.class)
public abstract class SlowFallingUmbrella {

    @Shadow public abstract boolean isHolding(Item item);

    @Shadow public abstract ItemStack getMainHandStack();

    @Shadow public abstract ItemStack getOffHandStack();

    @ModifyVariable(method = "travel",at = @At(value = "STORE"),slice = @Slice(from = @At(value = "INVOKE",target = "Lnet/minecraft/entity/LivingEntity;isLogicalSideForUpdatingMovement()Z")),ordinal = 0)
    double depresseFallSlowe(double value){

        LivingEntity liv = ((LivingEntity)((Object)this));
        if(liv.getVelocity().getY()<0)
        {

            if(this.getMainHandStack().getItem()==Wenospeakumbrellarino.UMBRELLA_ITEM)
            {
                if(this.getMainHandStack().getOrCreateNbt().getBoolean("isOpen"))
                {
                    value/=8;
                    liv.onLanding();
                }
            }
            if(this.getOffHandStack().getItem()==Wenospeakumbrellarino.UMBRELLA_ITEM)
            {
                if(this.getOffHandStack().getOrCreateNbt().getBoolean("isOpen"))
                {
                    value/=8;
                    liv.onLanding();
                }
            }
        }
        else{
            if(this.getMainHandStack().getItem()==Wenospeakumbrellarino.UMBRELLA_ITEM)
            {
                if(this.getMainHandStack().getOrCreateNbt().getBoolean("isOpen"))
                {
                    value*=2;
                    liv.onLanding();
                }
            }
            if(this.getOffHandStack().getItem()==Wenospeakumbrellarino.UMBRELLA_ITEM)
            {
                if(this.getOffHandStack().getOrCreateNbt().getBoolean("isOpen"))
                {
                    value*=2;
                    liv.onLanding();
                }
            }
        }
        return value;
    }
}
