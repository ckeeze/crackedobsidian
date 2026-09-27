package net.ckeeze.crackedobsidian.common;

import net.ckeeze.crackedobsidian.CrackedObsidian;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier STONEAGEOBSIDIAN = TierSortingRegistry.registerTier(
            new ForgeTier(1, 16, 4.0F, 5.5F, 15, BlockTags.NEEDS_STONE_TOOL, () -> Ingredient.of(Tags.Items.OBSIDIAN)),
            new ResourceLocation(CrackedObsidian.MODID, "macuahuitl"), List.of(Tiers.STONE), List.of(Tiers.IRON));
}
