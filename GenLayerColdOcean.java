package net.minecraft.src;

public class GenLayerColdOcean extends GenLayer {
	public GenLayerColdOcean(long var1, GenLayer var3) {
        super(var1);
        this.parent = var3;
    }
	
	public int[] getInts(int var1, int var2, int var3, int var4) {
		int[] var5 = this.parent.getInts(var1, var2, var3, var4);
		int[] var6 = IntCache.getIntCache(var3 * var4);

		for(int var7 = 0; var7 < var4; ++var7) {
			for(int var8 = 0; var8 < var3; ++var8) {
				this.initChunkSeed((long)(var8 + var1), (long)(var7 + var2));
				int var9 = var5[var8 + var7 * var3];
				if(var9 == BiomeGenBase.ocean.biomeID) {
					if(this.nextInt(5) == 0) {
						var6[var8 + var7 * var3] = BiomeGenBase.coldOcean.biomeID;
					} else {
						var6[var8 + var7 * var3] = var9;
					}
				} else {
					var6[var8 + var7 * var3] = var9;
				}
			}
		}
		return var6;
	}
}