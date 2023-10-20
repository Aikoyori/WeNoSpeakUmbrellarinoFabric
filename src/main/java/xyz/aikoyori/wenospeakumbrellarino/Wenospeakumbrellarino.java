package xyz.aikoyori.wenospeakumbrellarino;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import xyz.aikoyori.wenospeakumbrellarino.item.UmbrellaItem;

public class Wenospeakumbrellarino implements ModInitializer {

    public static final String MOD_ID = "wenospeakumbrellarino";
    public static final UmbrellaItem UMBRELLA_ITEM = new UmbrellaItem(new Item.Settings());

    @Override
    public void onInitialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.add(UMBRELLA_ITEM);
        });

        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "umbrella"), UMBRELLA_ITEM);
    }
}
