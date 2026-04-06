package net.minecraft.src;

import java.util.Random;
import java.util.List;

public class BlockFlower extends Block {
	private Icon[] iconArray;
	public static final String[] FLOWER_TYPES = new String[]{"rose", "blue_orchid", "allium", "azure_bluet", "red_tulip", "orange_tulip", "white_tulip", "pink_tulip", "oxeye_daisy", "yellow_tulip", "poppy", "carnation", "paeonia", "black_rose"};
	
	protected BlockFlower(int var1, Material var2) {
		super(var1, var2);
		this.setTickRandomly(true);
		float var3 = 0.2F;
		this.setBlockBounds(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var3 * 3.0F, 0.5F + var3);
		this.setCreativeTab(CreativeTabs.tabDecorations);
	}
	
	public int damageDropped(int var1) {
		return var1;
	}
	
	public void getSubBlocks(int var1, CreativeTabs var2, List var3) {
		if(var1 == Block.plantRed.blockID) {
			var3.add(new ItemStack(var1, 1, 0)); //rose *
			var3.add(new ItemStack(var1, 1, 1)); //blue orchid *
			var3.add(new ItemStack(var1, 1, 2)); //allium *
			var3.add(new ItemStack(var1, 1, 3)); //azure bluet *
			var3.add(new ItemStack(var1, 1, 4)); //tulips *
			var3.add(new ItemStack(var1, 1, 5)); //tulips *
			var3.add(new ItemStack(var1, 1, 6)); //tulips *
			var3.add(new ItemStack(var1, 1, 7)); //tulips *
			var3.add(new ItemStack(var1, 1, 8)); //oxeye daisy *
			var3.add(new ItemStack(var1, 1, 9)); //yellow tulip *
			var3.add(new ItemStack(var1, 1, 10)); //poppy 
			var3.add(new ItemStack(var1, 1, 11)); //carnation
			var3.add(new ItemStack(var1, 1, 12)); //paeonia
			var3.add(new ItemStack(var1, 1, 13)); //black rose
			
		} else {
			var3.add(new ItemStack(var1, 1, 0));
		}
	}
	
	public void registerIcons(IconRegister var1) {
		if(this.blockID == Block.plantRed.blockID) {
			this.iconArray = new Icon[FLOWER_TYPES.length];
			for(int var2 = 0; var2 < this.iconArray.length; ++var2) {
				this.iconArray[var2] = var1.registerIcon(FLOWER_TYPES[var2]);
			}
		} else {
			super.registerIcons(var1);
		}
	}
	
	public Icon getIcon(int side, int meta) {
		if (this.iconArray != null) {
			return this.iconArray[meta % this.iconArray.length];
		}
		return super.getIcon(side, meta);
	}

	protected BlockFlower(int var1) {
		this(var1, Material.plants);
	}

	public boolean canPlaceBlockAt(World var1, int var2, int var3, int var4) {
		return super.canPlaceBlockAt(var1, var2, var3, var4) && this.canThisPlantGrowOnThisBlockID(var1.getBlockId(var2, var3 - 1, var4));
	}

	protected boolean canThisPlantGrowOnThisBlockID(int var1) {
		return var1 == Block.grass.blockID || var1 == Block.dirt.blockID || var1 == Block.tilledField.blockID;
	}

	public void onNeighborBlockChange(World var1, int var2, int var3, int var4, int var5) {
		super.onNeighborBlockChange(var1, var2, var3, var4, var5);
		this.checkFlowerChange(var1, var2, var3, var4);
	}

	public void updateTick(World var1, int var2, int var3, int var4, Random var5) {
		this.checkFlowerChange(var1, var2, var3, var4);
	}

	protected final void checkFlowerChange(World var1, int var2, int var3, int var4) {
		if(!this.canBlockStay(var1, var2, var3, var4)) {
			this.dropBlockAsItem(var1, var2, var3, var4, var1.getBlockMetadata(var2, var3, var4), 0);
			var1.setBlockToAir(var2, var3, var4);
		}

	}

	public boolean canBlockStay(World var1, int var2, int var3, int var4) {
		return (var1.getFullBlockLightValue(var2, var3, var4) >= 8 || var1.canBlockSeeTheSky(var2, var3, var4)) && this.canThisPlantGrowOnThisBlockID(var1.getBlockId(var2, var3 - 1, var4));
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World var1, int var2, int var3, int var4) {
		return null;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public int getRenderType() {
		return 1;
	}
}
