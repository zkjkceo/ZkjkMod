package net.minecraft.src;

public class EntityGolderfish extends EntityMob {

	public EntityGolderfish(World var1) {
		super(var1);
		this.texture = "/mob/golderfish.png";
		this.setSize(0.3F, 0.7F);
		this.moveSpeed = 4.0F;
		this.fleeingTick = 1000;
	}
	
	public boolean attackEntityFrom(DamageSource var1, int var2) {
    boolean result = super.attackEntityFrom(var1, var2);

		if (result) {
			this.entityToAttack = null;
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
	}

	protected boolean isValidLightLevel() {
		return true;
	}

	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.ARTHROPOD;
	}
}
