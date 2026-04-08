package net.minecraft.src;

import java.util.Random;

public class BiomeGenDeepOcean extends BiomeGenBase {
	public BiomeGenDeepOcean(int var1) {
		super(var1);
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.add(new SpawnListEntry(EntitySpider.class, 10, 8, 8));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityZombie.class, 10, 8, 8));
		this.spawnableMonsterList.add(new SpawnListEntry(EntitySkeleton.class, 10, 8, 8));
		//this.spawnableMonsterList.add(new SpawnListEntry(EntityCreeper.class, 10, 8, 8)); do not alter creeper
		//this.spawnableMonsterList.add(new SpawnListEntry(EntitySlime.class, 10, 8, 8)); do not alter slime
		//this.spawnableMonsterList.add(new SpawnListEntry(EntityEnderman.class, 1, 1, 4)); do not alter enderman
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
