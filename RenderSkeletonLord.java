package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class RenderSkeletonLord extends RenderBiped {
	public RenderSkeletonLord() {
		super(new ModelSkeletonLord(), 0.5F);
	}

	protected void func_82438_a(EntitySkeletonLord var1, float var2) {
		GL11.glScalef(1.8F, 1.8F, 1.8F);
	}

	protected void func_82422_c() {
		GL11.glTranslatef(0.09375F, 3.0F / 16.0F, 0.0F);
	}

	protected void preRenderCallback(EntityLiving var1, float var2) {
		this.func_82438_a((EntitySkeletonLord)var1, var2);
	}
}
