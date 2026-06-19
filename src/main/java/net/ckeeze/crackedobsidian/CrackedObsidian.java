package net.ckeeze.crackedobsidian;

import com.mojang.logging.LogUtils;
import net.ckeeze.crackedobsidian.common.ExplosionEventHandler;
import net.ckeeze.crackedobsidian.common.ModCreativeTab;
import net.ckeeze.crackedobsidian.common.Registers;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CrackedObsidian.MODID)
public class CrackedObsidian {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "crackedobsidian";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "crackedobsidian" namespace

    public CrackedObsidian(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();
        modEventBus.addListener(this::commonSetup);

        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(ExplosionEventHandler.class);

        ModCreativeTab.register(modEventBus);

        Registers.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        BlockResistanceUtil.setResistance(Blocks.OBSIDIAN, (float) Config.ExplosionResistance);
    }
}
