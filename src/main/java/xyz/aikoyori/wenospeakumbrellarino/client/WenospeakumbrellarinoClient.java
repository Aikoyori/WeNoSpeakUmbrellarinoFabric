package xyz.aikoyori.wenospeakumbrellarino.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;
import xyz.aikoyori.wenospeakumbrellarino.Wenospeakumbrellarino;

@Environment(EnvType.CLIENT)
public class WenospeakumbrellarinoClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModelPredicateProviderRegistry.register(Wenospeakumbrellarino.UMBRELLA_ITEM, new Identifier("open"),
                (stack, world, entity, seed) -> {
            if(stack.getItem()!=Wenospeakumbrellarino.UMBRELLA_ITEM) return 0.0f;
            return stack.getOrCreateNbt().getBoolean("isOpen")? 1:0;
                });

    }
}
