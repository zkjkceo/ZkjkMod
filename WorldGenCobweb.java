package net.minecraft.src;

import java.util.Random;

public class WorldGenCobweb extends WorldGenerator {
	
	public boolean generate(World var1, Random var2, int var3, int var4, int var5) {
		int var6 = var3;

		for(int i = 0; i < 20; i++) {
			int x = var3 + var2.nextInt(8) - var2.nextInt(8);
			int y = var4 + var2.nextInt(4) - var2.nextInt(4);
			int z = var5 + var2.nextInt(8) - var2.nextInt(8);

			if(var1.isAirBlock(x, y, z) && hasSolidNeighbor(var1, x, y, z)) {
				var1.setBlock(x, y, z, Block.web.blockID, 0, 2);
			}
		}

		return true;
	}
	
	private boolean hasSolidNeighbor(World world, int x, int y, int z) {
		return world.isBlockOpaqueCube(x - 1, y, z) ||
			   world.isBlockOpaqueCube(x + 1, y, z) ||
			   world.isBlockOpaqueCube(x, y - 1, z) ||
			   world.isBlockOpaqueCube(x, y + 1, z) ||
			   world.isBlockOpaqueCube(x, y, z - 1) ||
			   world.isBlockOpaqueCube(x, y, z + 1);
	}
}
