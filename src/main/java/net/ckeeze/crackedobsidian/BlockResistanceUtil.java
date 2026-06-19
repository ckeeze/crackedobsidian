package net.ckeeze.crackedobsidian;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;

import java.lang.reflect.Field;

public class BlockResistanceUtil {
    public static void setResistance(Block block, float newResistance) {
        try {
            Field explosionResistance = ObfuscationReflectionHelper.findField(
                    BlockBehaviour.class, "f_60444_");
            explosionResistance.setAccessible(true);
            explosionResistance.set(block, newResistance);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException("Failed to change block hardness", e);
        }
    }
}
