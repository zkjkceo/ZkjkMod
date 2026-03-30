package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class RenderClone extends RenderLiving {
	public RenderClone() {
		super(new ModelBiped(0.0F), 0.5F);
	}
	
	protected void preRenderCallback(EntityLiving entity, float partialTick) {
        GL11.glScalef(15.0F / 16.0F, 15.0F / 16.0F, 15.0F / 16.0F);
    }
}
