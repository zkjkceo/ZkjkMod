package net.minecraft.src;

public class ItemSponge extends ItemBlock {
	public ItemSponge(int var1) {
		super(var1);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

	public int getMetadata(int var1) {
		return var1;
	}
}
