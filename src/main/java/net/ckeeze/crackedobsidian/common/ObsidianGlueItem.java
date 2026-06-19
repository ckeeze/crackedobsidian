package net.ckeeze.crackedobsidian.common;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class ObsidianGlueItem extends Item {
    public ObsidianGlueItem(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext pContext) {
        if (!pContext.getLevel().isClientSide()) {
            BlockPos positionClicked = pContext.getClickedPos();
            BlockState positionClickedState = pContext.getLevel().getBlockState(positionClicked);
            Level level = pContext.getLevel();
            if (positionClickedState.is(Registers.DAMAGED_OBSIDIAN.get())) {
                level.setBlock(positionClicked, Blocks.OBSIDIAN.defaultBlockState(), 1);
                assert pContext.getPlayer() != null;
                level.playSound(null, pContext.getPlayer().getX(), pContext.getPlayer().getY(), pContext.getPlayer().getZ(),
                        SoundEvents.LAVA_EXTINGUISH, SoundSource.NEUTRAL, 0.4F, 0.6F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
                level.playSound(pContext.getPlayer(), positionClicked, SoundEvents.LAVA_EXTINGUISH, SoundSource.PLAYERS);
                pContext.getItemInHand().shrink(1);
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.FAIL;
    }
}
