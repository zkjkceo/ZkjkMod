package net.minecraft.src;

public class RenderGolderfish extends RenderLiving {
	public RenderGolderfish() {
		super(new ModelGolderfish(), 0.3F);
	}
	
	protected float getGolderfishDeathRotation(EntityGolderfish var1) {
		return 180.0F;
	}

	public void renderGolderfish(EntityGolderfish var1, double var2, double var4, double var6, float var8, float var9) {
		super.doRenderLiving(var1, var2, var4, var6, var8, var9);
	}

	protected int shouldGolderfishRenderPass(EntityGolderfish var1, int var2, float var3) {
		return -1;
	}

	protected float getDeathMaxRotation(EntityLiving var1) {
		return this.getGolderfishDeathRotation((EntityGolderfish)var1);
	}

	protected int shouldRenderPass(EntityLiving var1, int var2, float var3) {
		return this.shouldGolderfishRenderPass((EntityGolderfish)var1, var2, var3);
	}

	public void doRenderLiving(EntityLiving var1, double var2, double var4, double var6, float var8, float var9) {
		this.renderGolderfish((EntityGolderfish)var1, var2, var4, var6, var8, var9);
	}

	public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9) {
		this.renderGolderfish((EntityGolderfish)var1, var2, var4, var6, var8, var9);
	}
}
