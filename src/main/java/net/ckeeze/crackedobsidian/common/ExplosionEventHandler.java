package net.ckeeze.crackedobsidian.common;

import net.ckeeze.crackedobsidian.Config;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.level.ExplosionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;

import static net.ckeeze.crackedobsidian.common.DamagedObsidianBlock.DAMAGE;

public class ExplosionEventHandler {

    @SubscribeEvent
    public static void ExplosionEvent(ExplosionEvent.Detonate event) {
        List<BlockPos> toBlow = event.getExplosion().getToBlow(); //shallow copy
        int ConfigDMG = Config.DamageStages;
        for (BlockPos blockpos : toBlow) {
            BlockState currblockstate = event.getLevel().getBlockState(blockpos);
            if (currblockstate.is(Registers.DAMAGED_OBSIDIAN.get())) {
                int currDamage = currblockstate.getValue(DAMAGE);
                if (currDamage + 2 < ConfigDMG && currDamage < 9) {
                    toBlow.remove(blockpos);
                    event.getLevel().setBlockAndUpdate(blockpos, Registers.DAMAGED_OBSIDIAN.get().defaultBlockState().setValue(DAMAGE, currDamage + 1));
                }
            }
            if (currblockstate.is(Blocks.OBSIDIAN) && ConfigDMG > 1) {
                toBlow.remove(blockpos);
                event.getLevel().setBlockAndUpdate(blockpos, Registers.DAMAGED_OBSIDIAN.get().defaultBlockState());
            }
        }
    }
}
