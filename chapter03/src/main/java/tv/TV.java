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

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public boolean isPower() {
		return power;
	}

	public void setPower(boolean power) {
		this.power = power;
	}

	
	
}
