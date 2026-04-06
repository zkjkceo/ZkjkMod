package net.minecraft.src;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class MapGenMineshaft extends MapGenStructure {
	private double field_82673_e = 0.01D;

	public MapGenMineshaft() {
	}

	public MapGenMineshaft(Map var1) {
		Iterator var2 = var1.entrySet().iterator();

		while(var2.hasNext()) {
			Entry var3 = (Entry)var2.next();
			if(((String)var3.getKey()).equals("chance")) {
				this.field_82673_e = MathHelper.parseDoubleWithDefault((String)var3.getValue(), this.field_82673_e);
			}
		}

	}

	protected boolean canSpawnStructureAtCoords(int var1, int var2) {
		int dist = Math.max(Math.abs(var1), Math.abs(var2));
		double distanceFactor = Math.min(dist / 300.0D, 1.0D);
		double chance = (1.0D / 300.0D) * distanceFactor;
		return this.rand.nextDouble() < chance;
	} // smaller chance for mineshaft, god i hate how many there are!

	protected StructureStart getStructureStart(int var1, int var2) {
		return new StructureMineshaftStart(this.worldObj, this.rand, var1, var2);
	}
}
