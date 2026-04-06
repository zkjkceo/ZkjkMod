package net.minecraft.src;

import java.util.Random;

public class BiomeGenOcean extends BiomeGenBase {
	public BiomeGenOcean(int var1) {
		super(var1);
		this.spawnableCreatureList.clear();
		this.theBiomeDecorator.azureBluetsPerChunk = 2;
	}

	
	//public void decorate(World var1, Random var2, int var3, int var4) {
	//	super.decorate(var1, var2, var3, var4);
	//	if(var2.nextInt(10) == 0) {
	//		int var5 = var3 + var2.nextInt(16) + 8;
	//		int var6 = var4 + var2.nextInt(16) + 8;
	//		WorldGenOceanTemples var7 = new WorldGenOceanTemples();
	//		var7.generate(var1, var2, var5, var1.getHeightValue(var5, var6) - var2.nextInt(20), var6);
	//	}
	//}
}
