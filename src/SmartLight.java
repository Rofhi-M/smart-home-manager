public class SmartLight extends SmartDevice {
    private int brightness;
    private String color;

    public SmartLight(String deviceName, String room, String isOn, int brightness, String color) {
        super(deviceName, room, isOn);
        this.brightness = brightness;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int  getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        if(brightness < 0 || brightness > 100) {
            throw new InvalidDeviceSettingException("Invalid brightness choice between 0 and 100");
        }

        this.brightness = brightness;
    }

    @Override
    public String toString() {
        return super.toString() + " | brightness: " + brightness + " | color: " + color;
    }

}
