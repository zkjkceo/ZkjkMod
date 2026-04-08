package net.minecraft.src;

import org.lwjgl.input.Keyboard;

public class GuiZkjkMod extends GuiScreen {

    public void initGui() {
        this.buttonList.clear();

        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, 80, getLogRotationText()));
		this.buttonList.add(new GuiButton(2, this.width / 2 - 100, 105, getFarEntitiesText()));
		this.buttonList.add(new GuiButton(3, this.width / 2 - 100, 130, getThunderText()));
		this.buttonList.add(new GuiButton(4, this.width / 2 - 100, 155, getSittingText()));
        this.buttonList.add(new GuiButton(30, this.width / 2 - 100, 180, "Done"));
    }

    protected void actionPerformed(GuiButton button) {
        if (button.id == 1) {
			ZkjkConfig.logRotation++;
			if (ZkjkConfig.logRotation > 2) {
				ZkjkConfig.logRotation = 0;
			}
			button.displayString = getLogRotationText();
			ZkjkConfig.save();
		}
		
		if (button.id == 2) {
			ZkjkConfig.farEntities++;
			if (ZkjkConfig.farEntities > 2) {
				ZkjkConfig.farEntities = 0;
			}
			button.displayString = getFarEntitiesText();
			ZkjkConfig.save();
		}
		
		if (button.id == 3) {
			ZkjkConfig.thunder++;
			if (ZkjkConfig.thunder > 1) {
				ZkjkConfig.thunder = 0;
			}
			button.displayString = getThunderText();
			ZkjkConfig.save();
		}
		
		if (button.id == 4) {
			ZkjkConfig.sitting++;
			if (ZkjkConfig.sitting > 1) {
				ZkjkConfig.sitting = 0;
			}
			button.displayString = getSittingText();
			ZkjkConfig.save();
		}

        if (button.id == 30) {
            this.mc.displayGuiScreen(null);
        }
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();

        this.drawCenteredString(this.fontRenderer, "ZkjkMod Config", this.width / 2, 40, 16777215);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    protected void keyTyped(char c, int key) {
        if (key == Keyboard.KEY_ESCAPE) {
            this.mc.displayGuiScreen(null);
        }
    }
	
	private String getLogRotationText() {
		switch (ZkjkConfig.logRotation) {
			case 0: return "Log Rotation: ON";
			case 1: return "Log Rotation: ON (Shift)";
			case 2: return "Log Rotation: OFF";
			default: return "Log Rotation: ?";
		}
	}
	
	private String getFarEntitiesText() {
		switch (ZkjkConfig.farEntities) {
			case 0: return "Far Entities: OFF";
			case 1: return "Far Entities: ON";
			case 2: return "Far Entities: ON (EXTREME)";
			default: return "Far Entities: ?";
		}
	}
	
	private String getThunderText() {
		switch (ZkjkConfig.thunder) {
			case 0: return "Thunder: ON";
			case 1: return "Thunder: OFF";
			default: return "Thunder: ?";
		}
	}
	
	private String getSittingText() {
		switch (ZkjkConfig.sitting) {
			case 0: return "Sitting: OFF";
			case 1: return "Sitting: ON";
			default: return "Sitting: ?";
		}
	}
}