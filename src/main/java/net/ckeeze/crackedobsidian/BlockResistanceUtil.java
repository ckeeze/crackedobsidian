package net.ckeeze.crackedobsidian;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.lang.reflect.Field;

public class BlockResistanceUtil {
    public static void setResistance(Block block, float newResistance) {
        try {
            Field explosionResistance = BlockBehaviour.class.getDeclaredField("explosionResistance");
            explosionResistance.setAccessible(true);
            explosionResistance.set(block, newResistance);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException("Failed to change block hardness", e);
        }
    }
}
