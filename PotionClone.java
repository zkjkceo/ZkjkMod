package net.minecraft.src;

public class PotionClone extends Potion {
	
	public PotionClone(int var1, boolean var2, int var3) {
		super(var1, var2, var3);
	}

	public boolean isInstant() {
		return true;
	}

	public boolean isReady(int var1, int var2) {
		return var1 >= 1;
	}
	
	public void performEffect(EntityLiving var1, int var2) {
		if(var1 instanceof EntityPlayer) {
			World world = var1.worldObj;
			EntityClone var4 = new EntityClone(world);
			var4.setPosition(var1.posX, var1.posY, var1.posZ);
			var4.setOwner(((EntityPlayer)var1).username);
			world.spawnEntityInWorld(var4);
			if (var2 > 0) {
				var4.setEntityHealth(20);
				var4.maxLifeTime = 3600;
				var4.damage = 6;
			} else {
				var4.setEntityHealth(5);
				var4.maxLifeTime = 1800;
				var4.damage = 3;
			}
		}
	}
}
