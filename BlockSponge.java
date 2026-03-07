package net.minecraft.src;

import java.util.Random;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

public class BlockSponge extends Block {
	private Icon[] iconArray;
	
	protected BlockSponge(int var1) {
		super(var1, Material.sponge);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	public Icon getIcon(int var1, int var2) {
		return this.iconArray[var2 % this.iconArray.length];
	}
	
	public int damageDropped(int var1) {
		return var1;
	}
	
	public void onNeighborBlockChange(World var1, int var2, int var3, int var4, int var5) {
		removeWater(var1, var2, var3, var4);
	}
	
	public void onBlockAdded(World var1, int var2, int var3, int var4) {
		removeWater(var1, var2, var3, var4);
	}
	
	private void removeWater(World var1, int var2, int var3, int var4) {
		int dataValue = var1.getBlockMetadata(var2, var3, var4);
		if(var1.getBlockMaterial(var2, var3 - 1, var4) == Material.water || var1.getBlockMaterial(var2, var3 + 1, var4)==Material.water || var1.getBlockMaterial(var2 + 1, var3, var4)==Material.water || var1.getBlockMaterial(var2 - 1, var3, var4)==Material.water || var1.getBlockMaterial(var2, var3, var4 + 1)==Material.water || var1.getBlockMaterial(var2, var3, var4 - 1)==Material.water)
		{
			if(dataValue == 0) {
				var1.setBlockMetadataWithNotify(var2, var3, var4, 1, 3);
				int spongePower = 7;
				Queue<int[]> queue = new LinkedList<int[]>();
				Set<String> visited = new HashSet<String>();

				queue.add(new int[]{var2, var3, var4, 0});
				visited.add(var2 + "," + var3 + "," + var4);

				while(!queue.isEmpty()) {
					int[] node = queue.poll();

					int x = node[0];
					int y = node[1];
					int z = node[2];
					int dist = node[3];

					if(dist > spongePower) continue;

					int[][] dirs = {
						{1,0,0}, {-1,0,0},
						{0,1,0}, {0,-1,0},
						{0,0,1}, {0,0,-1}
					};

					for(int[] d : dirs) {
						int nx = x + d[0];
						int ny = y + d[1];
						int nz = z + d[2];

						String key = nx + "," + ny + "," + nz;
						if(visited.contains(key)) continue;
						visited.add(key);

						if(var1.getBlockMaterial(nx, ny, nz) == Material.water) {

							var1.setBlockToAir(nx, ny, nz);

							queue.add(new int[]{nx, ny, nz, dist + 1});
						}
					}
				}
			}
		}
	}
	
	public void getSubBlocks(int var1, CreativeTabs var2, List var3) {
			var3.add(new ItemStack(var1, 1, 0));
			var3.add(new ItemStack(var1, 1, 1));
	}
	
	public void registerIcons(IconRegister var1) {
		this.iconArray = new Icon[2];

		for(int var2 = 0; var2 < this.iconArray.length; ++var2) {
			this.iconArray[var2] = var1.registerIcon("sponge_" + var2);
		}

	}
}
