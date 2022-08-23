package xyz.aikoyori.wenospeakumbrellarino.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class UmbrellaItem extends Item {
    public UmbrellaItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            ItemStack stc = user.getStackInHand(hand);
            boolean isUpLol = stc.getOrCreateNbt().getBoolean("isOpen");
            stc.getOrCreateNbt().putBoolean("isOpen", !isUpLol);
        }
        return super.use(world, user, hand);
    }


    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (entity instanceof LivingEntity liv) {
            //If this stack isn't being held, do nothing
            if(liv.getMainHandStack() != stack && liv.getOffHandStack() != stack)
                return;

            //Check if the umbrella is open...
            var isOpen = stack.getOrCreateNbt().getBoolean("isOpen");

            //If it is, and we're falling...
            if (liv.getVelocity().getY() < 0) {
                if(isOpen){
                    //Reduce vertical velocity!
                    liv.setVelocity(liv.getVelocity().multiply(1,0.8,1));
                    liv.onLanding();
                }
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }
}
