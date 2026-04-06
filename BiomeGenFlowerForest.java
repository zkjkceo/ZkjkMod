package net.minecraft.src;

import java.util.Random;

public class BiomeGenFlowerForest extends BiomeGenForest {
	public BiomeGenFlowerForest(int var1) {
		super(var1);
		this.theBiomeDecorator.treesPerChunk = 7;
		this.theBiomeDecorator.grassPerChunk = 1;
		this.theBiomeDecorator.tulipsPerChunk = 6; //tulips
		this.theBiomeDecorator.flowersPerChunk = 6; //rose and dendalion
		this.theBiomeDecorator.alliumsPerChunk = 3; //allium
		this.theBiomeDecorator.oxeyeDaisyPerChunk = 3; //oxeye daisy
		this.theBiomeDecorator.azureBluetsPerChunk = 3; //azure bluet
	}
}
