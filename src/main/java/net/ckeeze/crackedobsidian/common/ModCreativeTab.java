package net.ckeeze.crackedobsidian.common;

import net.ckeeze.crackedobsidian.CrackedObsidian;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CrackedObsidian.MODID);

    public static final RegistryObject<CreativeModeTab> CRACKED_OBSIDIAN_ITEM_TAB = CREATIVE_MODE_TABS.register("crackedobsidian_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(Registers.OBSIDIAN_SHARD.get()))
                    .title(Component.translatable("creativetab.crackedobsidian.items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(Registers.OBSIDIAN_GLUE.get());
                        output.accept(Registers.OBSIDIAN_SHARD.get());
                        output.accept(Registers.DAMAGED_OBSIDIAN.get().asItem());
                        output.accept(Registers.MACUAHUITL.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
