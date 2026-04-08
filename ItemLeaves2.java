package net.minecraft.src;

public class ItemLeaves2 extends ItemBlock {
	public ItemLeaves2(int var1) {
		super(var1);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

	public int getMetadata(int var1) {
		return var1 | 4;
	}

	public Icon getIconFromDamage(int var1) {
		return Block.leaves2.getIcon(0, var1);
	}

	public int getColorFromItemStack(ItemStack var1, int var2) {
		return ColorizerFoliage.getFoliageColorBasic();
	}

	public String getUnlocalizedName(ItemStack var1) {
		int var2 = var1.getItemDamage();
		if(var2 < 0 || var2 >= BlockLeaves2.LEAF_TYPES.length) {
			var2 = 0;
		}

		return super.getUnlocalizedName() + "." + BlockLeaves2.LEAF_TYPES[var2];
	}
}
