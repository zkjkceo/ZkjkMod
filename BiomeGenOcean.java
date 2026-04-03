package net.minecraft.src;

public class BiomeGenOcean extends BiomeGenBase {
	public BiomeGenOcean(int var1) {
		super(var1);
		this.theBiomeDecorator.treesPerChunk = 3; //some trees
		this.spawnableCreatureList.clear();
	}
}
