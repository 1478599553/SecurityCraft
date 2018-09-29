package net.geforcemods.securitycraft.blocks.reinforced;

import java.util.Arrays;
import java.util.List;

import net.geforcemods.securitycraft.SCContent;
import net.minecraft.block.Block;

public interface IReinforcedBlock
{
	public static final List<Block> BLOCKS = Arrays.asList(new Block[] {
			SCContent.reinforcedBoneBlock,
			SCContent.reinforcedBrick,
			SCContent.reinforcedCarpet,
			SCContent.reinforcedCobblestone,
			SCContent.reinforcedCompressedBlocks,
			SCContent.reinforcedConcrete,
			SCContent.reinforcedDirt,
			SCContent.reinforcedEndStone,
			SCContent.reinforcedEndStoneBricks,
			SCContent.reinforcedGlass,
			SCContent.reinforcedGlassPane,
			SCContent.reinforcedGlowstone,
			SCContent.reinforcedHardenedClay,
			SCContent.reinforcedIronBars,
			SCContent.reinforcedMetals,
			SCContent.reinforcedMossyCobblestone,
			SCContent.reinforcedNetherBrick,
			SCContent.reinforcedNetherrack,
			SCContent.reinforcedNewLogs,
			SCContent.reinforcedObsidian,
			SCContent.reinforcedOldLogs,
			SCContent.reinforcedPrismarine,
			SCContent.reinforcedPurpur,
			SCContent.reinforcedQuartz,
			SCContent.reinforcedRedNetherBrick,
			SCContent.reinforcedRedSandstone,
			SCContent.reinforcedSandstone,
			SCContent.reinforcedSeaLantern,
			SCContent.reinforcedStainedGlass,
			SCContent.reinforcedStainedGlassPanes,
			SCContent.reinforcedStainedHardenedClay,
			SCContent.reinforcedStone,
			SCContent.reinforcedStoneBrick,
			SCContent.reinforcedWoodPlanks,
			SCContent.reinforcedWool
	});

	public List<Block> getVanillaBlocks();

	public int getAmount();
}
