package net.ckeeze.crackedobsidian;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = CrackedObsidian.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {

    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.IntValue DAMAGESTAGES = BUILDER
            .comment("How many total explosions should completely destroy an obsidian block? Setting this to 1 disables the Damage stages")
            .comment("Ex: 3 Means Obsidian becomes Damaged and blows up during the 3rd explosion, taking 3 explosions total")
            .comment("Range: 1 - 11")
            .comment("Default: 4")
            .defineInRange("DamageStages", 4, 1, 11);

    private static final ForgeConfigSpec.DoubleValue EXPLOSIONRESISTANCE = BUILDER
            .comment("This determines what level of explosions can begin to crack Obsidian, Higher values means stronger Obsidian")
            .comment("Around 13.0 TNT Starts to damage obsidian in a small radius, 1200.0 is the vanilla default")
            .comment("Range: 0.0 - 10000.0")
            .comment("Default: 12.0")
            .defineInRange("ExplosionResistance", 12.0, 0.0, 10000.0);

    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static int DamageStages;
    public static double ExplosionResistance;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        DamageStages = DAMAGESTAGES.get();
        ExplosionResistance = EXPLOSIONRESISTANCE.get();
    }
}
