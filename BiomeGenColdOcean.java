package net.minecraft.src;

import java.util.Random;

public class BiomeGenColdOcean extends BiomeGenBase {
	public BiomeGenColdOcean(int var1) {
		super(var1);
		this.theBiomeDecorator.treesPerChunk = 3; //some trees
		this.spawnableCreatureList.clear();
	}
	
	public WorldGenerator getRandomWorldGenForTrees(Random var1) {
		return (WorldGenerator)(var1.nextInt(3) == 0 ? new WorldGenTaiga1() : new WorldGenTaiga2(false));
	} //cold trees
}
