package net.minecraft.src;

import java.util.Random;

public class BiomeGenRoofedForest extends BiomeGenBase {
	
	public BiomeGenRoofedForest(int var1) {
		super(var1);
		this.theBiomeDecorator.treesPerChunk = 10;
		this.theBiomeDecorator.grassPerChunk = 2;
	}
	public WorldGenerator getRandomWorldGenForTrees(Random var1) {
		return (WorldGenerator)(new WorldGenHugeTrees2(false, 4 + var1.nextInt(4), 1, 1));
	}
	
	public int getBiomeGrassColor() {
		int base = super.getBiomeGrassColor() & 0xFEFEFE;
		int dark = 0x28340A;
		int r = (((base >> 16) & 0xFF) + ((dark >> 16) & 0xFF)) / 2;
		int g = (((base >> 8) & 0xFF) + ((dark >> 8) & 0xFF)) / 2;
		int b = (((base) & 0xFF) + ((dark) & 0xFF)) / 2;
		return (r << 16) | (g << 8) | b;
	}

	public int getBiomeFoliageColor() {
		int base = super.getBiomeFoliageColor() & 0xFEFEFE;
		int dark = 0x28340A;
		int r = (((base >> 16) & 255) + ((dark >> 16) & 255)) >> 1;
		int g = (((base >> 8) & 255) + ((dark >> 8) & 255)) >> 1;
		int b = ((base & 255) + (dark & 255)) >> 1;
		return (r << 16) | (g << 8) | b;
	}
	
	public void decorate(World world, Random rand, int x, int z) {
		int var5;
        int var6;
        int var7;
        int var8;
        int var9;
		super.decorate(world, rand, x, z);
		for (var5 = 0; var5 < 4; ++var5)
        {
			for (var6 = 0; var6 < 4; ++var6)
			{
				var7 = x + var5 * 4 + 1 + 8 + rand.nextInt(3);
				var8 = z + var6 * 4 + 1 + 8 + rand.nextInt(3);
				var9 = world.getHeightValue(var7, var8);

				if (rand.nextInt(2) == 0)
				{
					WorldGenBigMushroom var10 = new WorldGenBigMushroom();
					var10.generate(world, rand, var7, var9, var8);
				}
			}
        }
	}
}
