package xyz.aikoyori.wenospeakumbrellarino;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import xyz.aikoyori.wenospeakumbrellarino.item.UmbrellaItem;

public class Wenospeakumbrellarino implements ModInitializer {

    public static final String MOD_ID = "wenospeakumbrellarino";
    public static final UmbrellaItem UMBRELLA_ITEM = new UmbrellaItem(new Item.Settings().group(ItemGroup.TOOLS));
    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM,new Identifier(MOD_ID,"umbrella"),UMBRELLA_ITEM);

    }
}
