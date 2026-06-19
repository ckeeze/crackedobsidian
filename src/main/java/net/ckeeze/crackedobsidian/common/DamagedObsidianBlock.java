package net.ckeeze.crackedobsidian.common;

import net.ckeeze.crackedobsidian.Config;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.NotNull;

public class DamagedObsidianBlock extends Block {
    public static final IntegerProperty DAMAGE = IntegerProperty.create("damage", 0, 9);

    public DamagedObsidianBlock(Properties properties) {
        super(properties);
        registerDefaultState(stateDefinition.any().setValue(DAMAGE, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(DAMAGE);
    }

    @Override
    public void onBlockExploded(BlockState state, Level level, BlockPos pos, Explosion explosion) {
        int DamageStages = Config.DamageStages;
        int CurrDamage = state.getValue(DAMAGE);
        if (CurrDamage + 2 < DamageStages && CurrDamage < 9) {
            level.setBlockAndUpdate(pos, state.setValue(DAMAGE, CurrDamage + 1));
        } else {
            level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
            this.wasExploded(level, pos, explosion);
        }
    }

    @Override
    public boolean dropFromExplosion(@NotNull Explosion explosion) {
        return false;
    }
}
