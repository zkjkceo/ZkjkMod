package net.minecraft.src;

import java.util.Random;

public class BiomeGenRoofedForest extends BiomeGenBase {
	public BiomeGenRoofedForest(int var1) {
		super(var1);
		this.theBiomeDecorator.treesPerChunk = 15;
		this.theBiomeDecorator.grassPerChunk = 2;
		//placeholder, no dark oak yet
	}
}
