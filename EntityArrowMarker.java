package net.minecraft.src;

import java.util.List;

public class EntityArrowMarker extends EntityArrow {
	
	public EntityArrowMarker(World var1) {
		super(var1);
	}

	public void onUpdate() {
		if (!this.worldObj.isRemote) {
			if (this.ticksExisted > 5 && this.riddenByEntity == null) {
				this.setDead();
				return;
			}
			this.motionX = 0;
			this.motionY = 0;
			this.motionZ = 0;
		} else {
			this.motionX = 0;
			this.motionY = 0;
			this.motionZ = 0;
		}
	}
	
	public boolean canBeCollidedWith() {
        return false;
    }
}
