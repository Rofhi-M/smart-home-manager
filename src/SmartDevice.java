public class SmartDevice {
    private String deviceName;
    private String room;
    private boolean isOn;

    public SmartDevice(String deviceName, String room, boolean isOn) {
        this.deviceName = deviceName;
        this.room = room;
        this.isOn = isOn;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName){
        if(deviceName == null) {
            System.out.println("Please enter a device name");
            return;
        }
        this.deviceName = deviceName;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        if(room == null) {
            System.out.println("Please enter a room name");
        }
        this.room = room;
    }

    public boolean getIsOn() {
        return isOn;
    }

    public void setIsOn(boolean isOn) {
        this.isOn = isOn;
    }

    @Override
    public String toString() {
        return "Device name: " + deviceName + "| room: " + room + "| isOn: " + isOn;
    }
}
