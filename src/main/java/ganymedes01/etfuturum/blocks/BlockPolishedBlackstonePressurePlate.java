package ganymedes01.etfuturum.blocks;

import ganymedes01.etfuturum.EtFuturum;
import ganymedes01.etfuturum.core.utils.Utils;
import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.material.Material;

public class BlockPolishedBlackstonePressurePlate extends BlockPressurePlate {
	public BlockPolishedBlackstonePressurePlate() {
		super("polished_blackstone", Material.rock, Sensitivity.everything);
		setHardness(0.5F);
		setResistance(0.5F);
		setBlockName(Utils.getUnlocalisedName("polished_blackstone_pressure_plate"));
		setCreativeTab(EtFuturum.creativeTabBlocks);
	}
}
