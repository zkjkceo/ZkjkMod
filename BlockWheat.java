package net.minecraft.src;

import java.util.List;
import java.util.Random;

public class BlockWheat extends Block {
	public static final String[] wheatType = new String[]{"wheat"};
	public static final String[] wheatTextureTypes = new String[]{"wheat_side"};
	private Icon[] iconArray;
	private Icon wheat_top;

	protected BlockWheat(int var1) {
		super(var1, Material.leaves);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}

	public int getRenderType() {
		return 31;
	}

	public int quantityDropped(Random var1) {
		return 1;
	}

	public int idDropped(int var1, Random var2, int var3) {
		return Block.blockWheat.blockID;
	}

	public int onBlockPlaced(World var1, int var2, int var3, int var4, int var5, float var6, float var7, float var8, int var9) {
		int var10 = var9 & 3;
		byte var11 = 0;
		switch(var5) {
		case 0:
		case 1:
			var11 = 0;
			break;
		case 2:
		case 3:
			var11 = 8;
			break;
		case 4:
		case 5:
			var11 = 4;
		}

		return var10 | var11;
	}

	public Icon getIcon(int var1, int var2) {
		int var3 = var2 & 12;
		int var4 = var2 & 3;
		return var3 != 0 || var1 != 1 && var1 != 0 ? (var3 != 4 || var1 != 5 && var1 != 4 ? (var3 != 8 || var1 != 2 && var1 != 3 ? this.iconArray[var4] : this.wheat_top) : this.wheat_top) : this.wheat_top;
	}

	public int damageDropped(int var1) {
		return var1 & 3;
	}

	public static int limitToValidMetadata(int var0) {
		return var0 & 3;
	}

	protected ItemStack createStackedBlock(int var1) {
		return new ItemStack(this.blockID, 1, limitToValidMetadata(var1));
	}

	public void registerIcons(IconRegister var1) {
		this.wheat_top = var1.registerIcon("wheat_top");
		this.iconArray = new Icon[wheatTextureTypes.length];

		for(int var2 = 0; var2 < this.iconArray.length; ++var2) {
			this.iconArray[var2] = var1.registerIcon(wheatTextureTypes[var2]);
		}

	}
}
