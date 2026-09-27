package net.ckeeze.crackedobsidian.common;

import net.ckeeze.crackedobsidian.Config;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static net.ckeeze.crackedobsidian.CrackedObsidian.MODID;

public class Registers {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    public static final RegistryObject<Item> OBSIDIAN_GLUE = ITEMS.register("obsidian_glue",
            () -> new ObsidianGlueItem(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> OBSIDIAN_SHARD = ITEMS.register("obsidian_shard",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MACUAHUITL = ITEMS.register("macuahuitl",
            () -> new SwordItem(ModToolTiers.STONEAGEOBSIDIAN, 5, -3.2F, new Item.Properties()));


    public static final RegistryObject<Block> DAMAGED_OBSIDIAN = registerBlock("damaged_obsidian",
            () -> new DamagedObsidianBlock(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).explosionResistance((float) Config.ExplosionResistance)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
    }
}
