package net.ckeeze.crackedobsidian.common;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

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
}
