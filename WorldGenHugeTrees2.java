package net.minecraft.src;

import java.util.Random;

public class WorldGenHugeTrees2 extends WorldGenerator {

	public WorldGenHugeTrees2(boolean var1) {
		super(var1);
	}
	
	//translated code from 1.7
    public boolean generate(World world, Random rand, int x, int y, int z)
    {
        int var6 = rand.nextInt(3) + rand.nextInt(2) + 6;
        boolean var7 = true;

        if (y >= 1 && y + var6 + 1 <= 256)
        {
            int var10;
            int var11;

            for (int var8 = y; var8 <= y + 1 + var6; ++var8)
            {
                byte var9 = 1;

                if (var8 == y)
                {
                    var9 = 0;
                }

                if (var8 >= y + 1 + var6 - 2)
                {
                    var9 = 2;
                }

                for (var10 = x - var9; var10 <= x + var9 && var7; ++var10)
                {
                    for (var11 = z - var9; var11 <= z + var9 && var7; ++var11)
                    {
                        if (var8 >= 0 && var8 < 256)
                        {
                            if (!isReplaceable(world, var10, var8, var11))
                            {
                                var7 = false;
                            }
                        }
                        else
                        {
                            var7 = false;
                        }
                    }
                }
            }

            if (!var7)
            {
                return false;
            }
            else
            {
                int var20 = world.getBlockId(x, y - 1, z);
                if ((var20 == Block.grass.blockID || var20 == Block.dirt.blockID) && y < 256 - var6 - 1)
                {
                    world.setBlock(x, y - 1, z, Block.dirt.blockID, 0, 2);
                    world.setBlock(x + 1, y - 1, z, Block.dirt.blockID, 0, 2);
                    world.setBlock(x + 1, y - 1, z + 1, Block.dirt.blockID, 0, 2);
                    world.setBlock(x, y - 1, z + 1, Block.dirt.blockID, 0, 2);
                    int var21 = rand.nextInt(4);
                    var10 = var6 - rand.nextInt(4);
                    var11 = 2 - rand.nextInt(3);
                    int var22 = x;
                    int var13 = z;
                    int var14 = 0;
                    int var15;
                    int var16;

                    for (var15 = 0; var15 < var6; ++var15)
                    {
                        var16 = y + var15;

                        if (var15 >= var10 && var11 > 0)
                        {
                            var22 += Direction.offsetX[var21];
                            var13 += Direction.offsetZ[var21];
                            --var11;
                        }

                        int var17 = world.getBlockId(var22, var16, var13);

                        if (var17 == 0 || var17 == Block.leaves2.blockID)
                        {
                            this.setBlockAndMetadata(world, var22, var16, var13, Block.wood2.blockID, 1);
                            this.setBlockAndMetadata(world, var22 + 1, var16, var13, Block.wood2.blockID, 1);
                            this.setBlockAndMetadata(world, var22, var16, var13 + 1, Block.wood2.blockID, 1);
                            this.setBlockAndMetadata(world, var22 + 1, var16, var13 + 1, Block.wood2.blockID, 1);
                            var14 = var16;
                        }
                    }

                    for (var15 = -2; var15 <= 0; ++var15)
                    {
                        for (var16 = -2; var16 <= 0; ++var16)
                        {
                            byte var23 = -1;
                            this.placeLeafIfAir(world, var22 + var15, var14 + var23, var13 + var16);
                            this.placeLeafIfAir(world, 1 + var22 - var15, var14 + var23, var13 + var16);
                            this.placeLeafIfAir(world, var22 + var15, var14 + var23, 1 + var13 - var16);
                            this.placeLeafIfAir(world, 1 + var22 - var15, var14 + var23, 1 + var13 - var16);

                            if ((var15 > -2 || var16 > -1) && (var15 != -1 || var16 != -2))
                            {
                                byte var24 = 1;
                                this.placeLeafIfAir(world, var22 + var15, var14 + var24, var13 + var16);
                                this.placeLeafIfAir(world, 1 + var22 - var15, var14 + var24, var13 + var16);
                                this.placeLeafIfAir(world, var22 + var15, var14 + var24, 1 + var13 - var16);
                                this.placeLeafIfAir(world, 1 + var22 - var15, var14 + var24, 1 + var13 - var16);
                            }
                        }
                    }

                    if (rand.nextBoolean())
                    {
                        this.placeLeafIfAir(world, var22, var14 + 2, var13);
                        this.placeLeafIfAir(world, var22 + 1, var14 + 2, var13);
                        this.placeLeafIfAir(world, var22 + 1, var14 + 2, var13 + 1);
                        this.placeLeafIfAir(world, var22, var14 + 2, var13 + 1);
                    }

                    for (var15 = -3; var15 <= 4; ++var15)
                    {
                        for (var16 = -3; var16 <= 4; ++var16)
                        {
                            if ((var15 != -3 || var16 != -3) && (var15 != -3 || var16 != 4) && (var15 != 4 || var16 != -3) && (var15 != 4 || var16 != 4) && (Math.abs(var15) < 3 || Math.abs(var16) < 3))
                            {
                                this.placeLeafIfAir(world, var22 + var15, var14, var13 + var16);
                            }
                        }
                    }

                    for (var15 = -1; var15 <= 2; ++var15)
                    {
                        for (var16 = -1; var16 <= 2; ++var16)
                        {
                            if ((var15 < 0 || var15 > 1 || var16 < 0 || var16 > 1) && rand.nextInt(3) <= 0)
                            {
                                int var25 = rand.nextInt(3) + 2;
                                int var18;

                                for (var18 = 0; var18 < var25; ++var18)
                                {
                                    this.setBlockAndMetadata(world, x + var15, var14 - var18 - 1, z + var16, Block.wood2.blockID, 1);
                                }

                                int var19;

                                for (var18 = -1; var18 <= 1; ++var18)
                                {
                                    for (var19 = -1; var19 <= 1; ++var19)
                                    {
                                        this.placeLeafIfAir(world, var22 + var15 + var18, var14 - 0, var13 + var16 + var19);
                                    }
                                }

                                for (var18 = -2; var18 <= 2; ++var18)
                                {
                                    for (var19 = -2; var19 <= 2; ++var19)
                                    {
                                        if (Math.abs(var18) != 2 || Math.abs(var19) != 2)
                                        {
                                            this.placeLeafIfAir(world, var22 + var15 + var18, var14 - 1, var13 + var16 + var19);
                                        }
                                    }
                                }
                            }
                        }
                    }

                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        else
        {
            return false;
        }
    }

    private void placeLeafIfAir(World world, int x, int y, int z) {
        int id = world.getBlockId(x, y, z);
        if (id == 0) {
            this.setBlockAndMetadata(world, x, y, z, Block.leaves2.blockID, 1);
        }
    }
	
	private boolean isReplaceable(World world, int x, int y, int z) {
    int id = world.getBlockId(x, y, z);
    return id == 0 ||
           id == Block.leaves.blockID ||
           id == Block.leaves2.blockID ||
           id == Block.wood.blockID ||
           id == Block.wood2.blockID ||
           id == Block.sapling.blockID ||
           id == Block.sapling2.blockID ||
           id == Block.grass.blockID ||
           id == Block.dirt.blockID;
	}
}
