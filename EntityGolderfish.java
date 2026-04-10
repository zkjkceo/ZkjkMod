package net.minecraft.src;

public class EntityGolderfish extends EntityMob {
	
	private int[] ORES_ID = new int[]{263, 265, 331, 351, 266, 264, 388};
	private int damageDrop = (int)(this.health/5);

	public EntityGolderfish(World var1) {
		super(var1);
		this.texture = "/mob/golderfish.png";
		this.setSize(0.3F, 0.7F);
		this.moveSpeed = 4.0F;
		this.fleeingTick = 2000; //100 seconds
	}

	public void initCreature() {
		this.damageDrop = (int)(this.getMaxHealth()/5);
	}
	
	public boolean attackEntityFrom(DamageSource var1, int var2) {
    boolean result = super.attackEntityFrom(var1, var2);

		if (result) {
			this.entityToAttack = null;
			if(var2 >= 5 && this.damageDrop > 0) {
				for(int var10 = (int)(var2 / 5); var10 > 0; var10--) {
					int oreToDrop = this.ORES_ID[this.rand.nextInt(4)];
					if (oreToDrop == 351) {
						ItemStack item = new ItemStack(Item.dyePowder.itemID, 1, 4);
						this.entityDropItem(item, 1); //lapis
					} else {
						this.dropItem(oreToDrop, 1); //other
					}
					this.damageDrop = (int)(this.health/5);
				}
			}
		}
		return result;
	}
	
	public int getMaxHealth() {
		return 200;
	}

	protected boolean canTriggerWalking() {
		return false;
	}

	protected Entity findPlayerToAttack() {
		return null;
	}
	
	protected void dropFewItems(boolean var1, int var2) {
		int[] ORES = new int[]{2 + this.rand.nextInt(12), 2 + this.rand.nextInt(12), 2 + this.rand.nextInt(12), 2 + this.rand.nextInt(12), 2 + this.rand.nextInt(6), 2 + this.rand.nextInt(6), 2 + this.rand.nextInt(6)};
		for(int i = 0; i < ORES.length; i++) {
			for(int j = ORES[i]; j > 0; j--) {
				if (this.ORES_ID[i] == 351) {
					ItemStack item = new ItemStack(Item.dyePowder.itemID, 1, 4);
					this.entityDropItem(item, 1); //lapis
				} else {
					this.dropItem(this.ORES_ID[i], 1); //other
				}
			}
		}
	}

	protected String getLivingSound() {
		return "mob.silverfish.say";
	}

	protected String getHurtSound() {
		return "mob.silverfish.hit";
	}

	protected String getDeathSound() {
		return "mob.silverfish.kill";
	}

	protected void attackEntity(Entity var1, float var2) {
	}

	protected void playStepSound(int var1, int var2, int var3, int var4) {
		this.playSound("mob.silverfish.step", 0.15F, 1.0F);
	}

	public void onUpdate() {
		this.renderYawOffset = this.rotationYaw;
		super.onUpdate();
		
		if (this.ticksExisted >= 2000) {
			this.setDead();
		}
	}

	protected boolean isValidLightLevel() {
		return true;
	}

	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.ARTHROPOD;
	}
}
