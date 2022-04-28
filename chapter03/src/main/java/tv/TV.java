package tv;

public class TV {
	private int channel;  // 0 ~ 255 rotation
	private int volume;   // 0 ~ 100 rotation
	private boolean power;
	
	public void vloume(boolean up) {
	}

	public void volume(int volume) {
	}

	public void status() {
		System.out.println(
				"TV[channel=" + channel + 
				", volume=" + volume + 
				", power=" + (power ? "on" : "off"));
	}
}
