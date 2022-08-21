package xyz.aikoyori.wenospeakumbrellarino.item;

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
        if(!world.isClient)
        {
            ItemStack stc = user.getStackInHand(hand);
            boolean isUpLol = stc.getOrCreateNbt().getBoolean("isOpen");
            stc.getOrCreateNbt().putBoolean("isOpen",!isUpLol);
        }
        return super.use(world, user, hand);
    }


}
