package net.minecraft.src;

import java.util.Random;

public class BiomeGenRoofedForest extends BiomeGenBase {
	
	public BiomeGenRoofedForest(int var1) {
		super(var1);
		this.theBiomeDecorator.treesPerChunk = 15;
		this.theBiomeDecorator.grassPerChunk = 10;
		this.theBiomeDecorator.mushroomsPerChunk = 10;
		this.theBiomeDecorator.bigMushroomsPerChunk = 4;
		this.theBiomeDecorator.cobwebPerChunk = 10;
		
		this.spawnableMonsterList.add(new SpawnListEntry(EntitySpider.class, 100, 6, 12));
		this.spawnableCreatureList.clear();
	}
	
	public WorldGenerator getRandomWorldGenForTrees(Random var1) {
		return (WorldGenerator)(var1.nextInt(3) == 0 ? this.worldGeneratorTrees : (var1.nextInt(3) == 0 ? this.worldGeneratorForest : (new WorldGenHugeTrees2(false))));
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
		super.decorate(world, rand, x, z);
	}
}
