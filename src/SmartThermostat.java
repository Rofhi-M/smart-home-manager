public class SmartThermostat extends SmartDevice {
    private String mode;
    private double temp;

    public SmartThermostat(String deviceName, String room, String isOn, String mode, double temp) {
        super(deviceName, room, isOn);
        this.mode = mode;
        this.temp = temp;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        if (mode == null || (!mode.equalsIgnoreCase("heating") && !mode.equalsIgnoreCase("cooling") && !mode.equalsIgnoreCase("off"))) {
            throw new InvalidDeviceSettingException("Invalid mode. Choose Heating, Cooling, or Off.");
        }
        this.mode = mode;
    }
    public double getTemp() {
        return temp;
    }
    public void setTemp(double temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return super.toString() + " | mode: " + mode + " | temp: " + temp;
    }
}
