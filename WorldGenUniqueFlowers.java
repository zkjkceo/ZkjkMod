package net.minecraft.src;

import java.util.Random;

public class WorldGenUniqueFlowers extends WorldGenerator {
	private int plantBlockId;
	private int plantBlockDv;
	private boolean tulips = false;

	public WorldGenUniqueFlowers(int var1, int dv) {
		this.plantBlockId = var1;
		if(dv==1000) {
			this.tulips = true;
		}
		this.plantBlockDv = dv;
	}

	public boolean generate(World var1, Random var2, int var3, int var4, int var5) {
		if(this.tulips) {
			for(int var6 = 0; var6 < 64; ++var6) {
				int var7 = var3 + var2.nextInt(8) - var2.nextInt(8);
				int var8 = var4 + var2.nextInt(4) - var2.nextInt(4);
				int var9 = var5 + var2.nextInt(8) - var2.nextInt(8);
				int randomTulip = 4 + var2.nextInt(4); //4-7
				if(var1.isAirBlock(var7, var8, var9) && (!var1.provider.hasNoSky || var8 < 127) && Block.blocksList[this.plantBlockId].canBlockStay(var1, var7, var8, var9)) {
					if(var2.nextInt(5) == 0) {
						var1.setBlock(var7, var8, var9, this.plantBlockId, 9, 2); //yellow tulip
					} else {
						var1.setBlock(var7, var8, var9, this.plantBlockId, randomTulip, 2); //the rest of tulips
					}
				}
			}
		} else {
			for(int var6 = 0; var6 < 64; ++var6) {
				int var7 = var3 + var2.nextInt(8) - var2.nextInt(8);
				int var8 = var4 + var2.nextInt(4) - var2.nextInt(4);
				int var9 = var5 + var2.nextInt(8) - var2.nextInt(8);
				if(var1.isAirBlock(var7, var8, var9) && (!var1.provider.hasNoSky || var8 < 127) && Block.blocksList[this.plantBlockId].canBlockStay(var1, var7, var8, var9)) {
					var1.setBlock(var7, var8, var9, this.plantBlockId, this.plantBlockDv, 2);
				}
			}
		}

		return true;
	}
}
