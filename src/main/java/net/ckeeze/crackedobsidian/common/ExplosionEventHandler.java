package net.ckeeze.crackedobsidian.common;

import net.ckeeze.crackedobsidian.Config;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.level.ExplosionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

public class ExplosionEventHandler {

    @SubscribeEvent
    public static void ExplosionEvent(ExplosionEvent.Detonate event) {
        List<BlockPos> toBlow = event.getExplosion().getToBlow(); //shallow copy
        ArrayList<BlockPos> toSave = new ArrayList<>();
        int ConfigDMG = Config.DamageStages;
        for (BlockPos blockpos : toBlow) {
            if (event.getLevel().getBlockState(blockpos).is(Blocks.OBSIDIAN) && ConfigDMG != 1) {
                event.getLevel().setBlockAndUpdate(blockpos, Registers.DAMAGED_OBSIDIAN.get().defaultBlockState());
                toSave.add(blockpos);
            }
        }
        for (BlockPos blockpos : toSave) {
            toBlow.remove(blockpos);
        }
    }
}
