package ganymedes01.etfuturum.blocks;

import ganymedes01.etfuturum.EtFuturum;
import ganymedes01.etfuturum.ModBlocks.IBurnableBlock;
import ganymedes01.etfuturum.core.utils.Utils;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockWoodFenceGate extends BlockFenceGate implements IBurnableBlock {

	private final int meta;

	public BlockWoodFenceGate(int meta) {
		this.meta = meta;
		setHardness(2.0F);
		setResistance(5.0F);
		setStepSound(soundTypeWood);
		setBlockName(Utils.getUnlocalisedName("fence_gate_" + meta));
		setCreativeTab(EtFuturum.enableFences ? EtFuturum.creativeTab : null);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return Blocks.planks.getIcon(side, this.meta);
	}
}