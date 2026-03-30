package net.minecraft.src;

import java.util.Calendar;

public class EntityClone extends EntityTameable {
	
	private int lifeTime = 0;
	public int maxLifeTime = 1800;
	public int damage = 3;

	public EntityClone(World var1) {
		super(var1);
		this.moveSpeed = 0.3F;
		this.setSize(0.6F, 1.8F);
		this.entityType = "humanoid";
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, this.moveSpeed, true));
		this.tasks.addTask(3, new EntityAIFollowOwner(this, this.moveSpeed, 10.0F, 2.0F));
		this.tasks.addTask(4, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
		this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
		this.setTamed(true);
	}
	
	public String getTexture() {
		return "/mob/clone.png";
	}
	
	public EntityAgeable createChild(EntityAgeable var1) {
		return null;
	}

	protected void entityInit() {
		super.entityInit();
	}

	public int getMaxHealth() {
		return 5;
	}
	
	public void onLivingUpdate() {
		super.onLivingUpdate();
		this.lifeTime++;
		if (this.lifeTime >= this.maxLifeTime) {
			this.setEntityHealth(0);
		}
	}
	
	public boolean attackEntityAsMob(Entity var1) {
		return var1.attackEntityFrom(DamageSource.causeMobDamage(this), damage);
	}
	
	public void writeEntityToNBT(NBTTagCompound tag) {
    super.writeEntityToNBT(tag);

    tag.setInteger("LifeTime", this.lifeTime);
    tag.setInteger("MaxLifeTime", this.maxLifeTime);
	tag.setInteger("Damage", this.damage);
	}
	
	public void readEntityFromNBT(NBTTagCompound tag) {
		super.readEntityFromNBT(tag);

		if (tag.hasKey("LifeTime")) {
			this.lifeTime = tag.getInteger("LifeTime");
		}

		if (tag.hasKey("MaxLifeTime")) {
			this.maxLifeTime = tag.getInteger("MaxLifeTime");
		}
		
		if (tag.hasKey("Damage")) {
			this.damage = tag.getInteger("Damage");
		}
	}

	protected boolean isAIEnabled() {
		return true;
	}

}
