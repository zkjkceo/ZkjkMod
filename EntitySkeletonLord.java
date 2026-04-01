package net.minecraft.src;

public class EntitySkeletonLord extends EntityMob implements IBossDisplayData, IRangedAttackMob {
	private EntityAIArrowAttack aiArrowAttack = new EntityAIArrowAttack(this, 0.25F, 20, 60, 15.0F);
	private EntityAIAttackOnCollide aiAttackOnCollide = new EntityAIAttackOnCollide(this, EntityPlayer.class, 0.31F, false);

	public EntitySkeletonLord(World var1) {
		super(var1);
		this.setEntityHealth(this.getMaxHealth());
		this.texture = "/mob/skeletonLord.png";
		this.moveSpeed = 0.4F;
		this.setSize(1.0F, 3.0F);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIRestrictSun(this));
		this.tasks.addTask(3, new EntityAIFleeSun(this, this.moveSpeed));
		this.tasks.addTask(5, new EntityAIWander(this, this.moveSpeed));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 16.0F, 0, true));
		if(var1 != null && !var1.isRemote) {
			this.setCombatTask();
		}
	}

	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(16, new Integer(this.getMaxHealth()));
	}
	
	public void initCreature() {
		this.addRandomArmor();
	}

	public boolean isAIEnabled() {
		return true;
	}

	public int getMaxHealth() {
		return 200;
	}

	protected String getLivingSound() {
		return "mob.skeleton.say";
	}

	protected String getHurtSound() {
		return "mob.skeleton.hurt";
	}

	protected String getDeathSound() {
		return "mob.skeleton.death";
	}

	protected void playStepSound(int var1, int var2, int var3, int var4) {
		this.playSound("mob.skeleton.step", 0.15F, 1.0F);
	}
	
	public void readEntityFromNBT(NBTTagCompound var1) {
		super.readEntityFromNBT(var1);
		this.dataWatcher.updateObject(16, Integer.valueOf(this.health));
		this.setCombatTask();
	}
	
	public void writeEntityToNBT(NBTTagCompound var1) {
		super.writeEntityToNBT(var1);
	}

	public boolean attackEntityAsMob(Entity var1) {
		if(super.attackEntityAsMob(var1)) {
			return true;
		} else {
			return false;
		}
	}

	public int getAttackStrength(Entity var1) {
		return super.getAttackStrength(var1);
	}

	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEAD;
	}

	public void onLivingUpdate() {
		if(!this.worldObj.isRemote) {
			this.dataWatcher.updateObject(16, Integer.valueOf(this.health));
			BossStatus.func_82824_a(this, true);
		}
		super.onLivingUpdate();
	}

	public void onDeath(DamageSource var1) {
		super.onDeath(var1);
		if(var1.getSourceOfDamage() instanceof EntityArrow && var1.getEntity() instanceof EntityPlayer) {
			EntityPlayer var2 = (EntityPlayer)var1.getEntity();
			double var3 = var2.posX - this.posX;
			double var5 = var2.posZ - this.posZ;
			if(var3 * var3 + var5 * var5 >= 2500.0D) {
				var2.triggerAchievement(AchievementList.snipeSkeleton);
			}
		}

	}

	public void setCombatTask() {
		this.tasks.removeTask(this.aiAttackOnCollide);
		this.tasks.removeTask(this.aiArrowAttack);
		ItemStack var1 = this.getHeldItem();
		if(var1 != null && var1.itemID == Item.bow.itemID) {
			this.tasks.addTask(4, this.aiArrowAttack);
		} else {
			this.tasks.addTask(4, this.aiAttackOnCollide);
		}

	}
	
	protected void addRandomArmor() {
		this.setCurrentItemOrArmor(0, new ItemStack(Item.bow));
	}

	public void attackEntityWithRangedAttack(EntityLiving var1, float var2) {
		EntityArrow var3 = new EntityArrow(this.worldObj, this, var1, 1.6F, (float)(14 - this.worldObj.difficultySetting * 4));
		int var4 = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, this.getHeldItem());
		int var5 = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, this.getHeldItem());
		var3.setDamage((double)(var2 * 2.0F) + this.rand.nextGaussian() * 0.25D + (double)((float)this.worldObj.difficultySetting * 0.11F));
		if(var4 > 0) {
			var3.setDamage(var3.getDamage() + (double)var4 * 0.5D + 0.5D);
		}

		if(var5 > 0) {
			var3.setKnockbackStrength(var5);
		}

		if(EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, this.getHeldItem()) > 0) {
			var3.setFire(100);
		}

		this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
		this.worldObj.spawnEntityInWorld(var3);
	}

	public void setCurrentItemOrArmor(int var1, ItemStack var2) {
		super.setCurrentItemOrArmor(var1, var2);
		if(!this.worldObj.isRemote && var1 == 0) {
			this.setCombatTask();
		}
	}
	
	public int getBossHealth() {
		return this.dataWatcher.getWatchableObjectInt(16);
	}
}
