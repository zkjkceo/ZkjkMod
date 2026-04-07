package net.minecraft.src;

import java.util.List;
import java.util.Random;

public class BlockSapling2 extends BlockFlower {
	public static final String[] WOOD_TYPES = new String[]{"placeholder", "dark_oak", "placeholder", "placeholder"};
	private static final String[] field_94370_b = new String[]{"sapling_placeholder", "sapling_dark_oak", "sapling_placeholder", "sapling_placeholder"};
	private Icon[] saplingIcon;

	protected BlockSapling2(int var1) {
		super(var1);
		float var2 = 0.4F;
		this.setBlockBounds(0.5F - var2, 0.0F, 0.5F - var2, 0.5F + var2, var2 * 2.0F, 0.5F + var2);
		this.setCreativeTab(CreativeTabs.tabDecorations);
	}

	public void updateTick(World var1, int var2, int var3, int var4, Random var5) {
		if(!var1.isRemote) {
			super.updateTick(var1, var2, var3, var4, var5);
			if(var1.getBlockLightValue(var2, var3 + 1, var4) >= 9 && var5.nextInt(7) == 0) {
				this.markOrGrowMarked(var1, var2, var3, var4, var5);
			}

		}
	}

	public Icon getIcon(int var1, int var2) {
		var2 &= 3;
		return this.saplingIcon[var2];
	}

	public void markOrGrowMarked(World var1, int var2, int var3, int var4, Random var5) {
		int var6 = var1.getBlockMetadata(var2, var3, var4);
		if((var6 & 8) == 0) {
			var1.setBlockMetadataWithNotify(var2, var3, var4, var6 | 8, 4);
		} else {
			this.growTree(var1, var2, var3, var4, var5);
		}

	}

	public void growTree(World var1, int var2, int var3, int var4, Random var5) {
		int var6 = var1.getBlockMetadata(var2, var3, var4) & 3;
		Object var7 = null;
		int var8 = 0;
		int var9 = 0;
		boolean var10 = false;
		if(var6 == 1) {
			for(var8 = 0; var8 >= -1; --var8) {
				for(var9 = 0; var9 >= -1; --var9) {
					if(this.isSameSapling(var1, var2 + var8, var3, var4 + var9, 1) && this.isSameSapling(var1, var2 + var8 + 1, var3, var4 + var9, 1) && this.isSameSapling(var1, var2 + var8, var3, var4 + var9 + 1, 1) && this.isSameSapling(var1, var2 + var8 + 1, var3, var4 + var9 + 1, 1)) {
						var7 = new WorldGenHugeTrees2(true, 0, 1, 1);
						var10 = true;
						break;
					}
				}

				if(var7 != null) {
					break;
				}
			}
		} else {
			var7 = new WorldGenHugeTrees2(true, 4, 1, 1);
		}

		if(var10) {
			var1.setBlock(var2 + var8, var3, var4 + var9, 0, 0, 4);
			var1.setBlock(var2 + var8 + 1, var3, var4 + var9, 0, 0, 4);
			var1.setBlock(var2 + var8, var3, var4 + var9 + 1, 0, 0, 4);
			var1.setBlock(var2 + var8 + 1, var3, var4 + var9 + 1, 0, 0, 4);
		} else {
			var1.setBlock(var2, var3, var4, 0, 0, 4);
		}

		if(!((WorldGenerator)var7).generate(var1, var5, var2 + var8, var3, var4 + var9)) {
			if(var10) {
				var1.setBlock(var2 + var8, var3, var4 + var9, this.blockID, var6, 4);
				var1.setBlock(var2 + var8 + 1, var3, var4 + var9, this.blockID, var6, 4);
				var1.setBlock(var2 + var8, var3, var4 + var9 + 1, this.blockID, var6, 4);
				var1.setBlock(var2 + var8 + 1, var3, var4 + var9 + 1, this.blockID, var6, 4);
			} else {
				var1.setBlock(var2, var3, var4, this.blockID, var6, 4);
			}
		}

	}

	public boolean isSameSapling(World var1, int var2, int var3, int var4, int var5) {
		return var1.getBlockId(var2, var3, var4) == this.blockID && (var1.getBlockMetadata(var2, var3, var4) & 3) == var5;
	}

	public int damageDropped(int var1) {
		return var1 & 3;
	}

	public void getSubBlocks(int var1, CreativeTabs var2, List var3) {
		//var3.add(new ItemStack(var1, 1, 0));
		var3.add(new ItemStack(var1, 1, 1)); //dark oak
		//var3.add(new ItemStack(var1, 1, 2));
		//var3.add(new ItemStack(var1, 1, 3));
	}

	public void registerIcons(IconRegister var1) {
		this.saplingIcon = new Icon[field_94370_b.length];

		for(int var2 = 0; var2 < this.saplingIcon.length; ++var2) {
			this.saplingIcon[var2] = var1.registerIcon(field_94370_b[var2]);
		}

	}
}
