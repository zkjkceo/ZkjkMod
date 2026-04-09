package net.minecraft.src;

public class ModelGolderfish extends ModelBase {
	private ModelRenderer[] golderfishBodyParts = new ModelRenderer[7];
	private ModelRenderer[] golderfishWings;
	private float[] field_78170_c = new float[7];
	private static final int[][] golderfishBoxLength = new int[][]{{3, 2, 2}, {4, 3, 2}, {6, 4, 3}, {3, 3, 3}, {2, 2, 3}, {2, 1, 2}, {1, 1, 2}};
	private static final int[][] golderfishTexturePositions = new int[][]{{0, 0}, {0, 4}, {0, 9}, {0, 16}, {0, 22}, {11, 0}, {13, 4}};

	public ModelGolderfish() {
		float var1 = -3.5F;

		for(int var2 = 0; var2 < this.golderfishBodyParts.length; ++var2) {
			this.golderfishBodyParts[var2] = new ModelRenderer(this, golderfishTexturePositions[var2][0], golderfishTexturePositions[var2][1]);
			this.golderfishBodyParts[var2].addBox((float)golderfishBoxLength[var2][0] * -0.5F, 0.0F, (float)golderfishBoxLength[var2][2] * -0.5F, golderfishBoxLength[var2][0], golderfishBoxLength[var2][1], golderfishBoxLength[var2][2]);
			this.golderfishBodyParts[var2].setRotationPoint(0.0F, (float)(24 - golderfishBoxLength[var2][1]), var1);
			this.field_78170_c[var2] = var1;
			if(var2 < this.golderfishBodyParts.length - 1) {
				var1 += (float)(golderfishBoxLength[var2][2] + golderfishBoxLength[var2 + 1][2]) * 0.5F;
			}
		}

		this.golderfishWings = new ModelRenderer[3];
		this.golderfishWings[0] = new ModelRenderer(this, 20, 0);
		this.golderfishWings[0].addBox(-5.0F, 0.0F, (float)golderfishBoxLength[2][2] * -0.5F, 10, 8, golderfishBoxLength[2][2]);
		this.golderfishWings[0].setRotationPoint(0.0F, 16.0F, this.field_78170_c[2]);
		this.golderfishWings[1] = new ModelRenderer(this, 20, 11);
		this.golderfishWings[1].addBox(-3.0F, 0.0F, (float)golderfishBoxLength[4][2] * -0.5F, 6, 4, golderfishBoxLength[4][2]);
		this.golderfishWings[1].setRotationPoint(0.0F, 20.0F, this.field_78170_c[4]);
		this.golderfishWings[2] = new ModelRenderer(this, 20, 18);
		this.golderfishWings[2].addBox(-3.0F, 0.0F, (float)golderfishBoxLength[4][2] * -0.5F, 6, 5, golderfishBoxLength[1][2]);
		this.golderfishWings[2].setRotationPoint(0.0F, 19.0F, this.field_78170_c[1]);
	}

	public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
		this.setRotationAngles(var2, var3, var4, var5, var6, var7, var1);

		int var8;
		for(var8 = 0; var8 < this.golderfishBodyParts.length; ++var8) {
			this.golderfishBodyParts[var8].render(var7);
		}

		for(var8 = 0; var8 < this.golderfishWings.length; ++var8) {
			this.golderfishWings[var8].render(var7);
		}

	}

	public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7) {
		for(int var8 = 0; var8 < this.golderfishBodyParts.length; ++var8) {
			this.golderfishBodyParts[var8].rotateAngleY = MathHelper.cos(var3 * 0.9F + (float)var8 * 0.15F * (float)Math.PI) * (float)Math.PI * 0.05F * (float)(1 + Math.abs(var8 - 2));
			this.golderfishBodyParts[var8].rotationPointX = MathHelper.sin(var3 * 0.9F + (float)var8 * 0.15F * (float)Math.PI) * (float)Math.PI * 0.2F * (float)Math.abs(var8 - 2);
		}

		this.golderfishWings[0].rotateAngleY = this.golderfishBodyParts[2].rotateAngleY;
		this.golderfishWings[1].rotateAngleY = this.golderfishBodyParts[4].rotateAngleY;
		this.golderfishWings[1].rotationPointX = this.golderfishBodyParts[4].rotationPointX;
		this.golderfishWings[2].rotateAngleY = this.golderfishBodyParts[1].rotateAngleY;
		this.golderfishWings[2].rotationPointX = this.golderfishBodyParts[1].rotationPointX;
	}
}
