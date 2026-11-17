import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DeviceLog {
    private final String device;
    private final String action;
    private final LocalDateTime timestamp;

    public DeviceLog(String device, String action) {
        this.device = device;
        this.action = action;
        this.timestamp = LocalDateTime.now();
    }

    public String getDevice(){
        return device;
    }

    public String getAction(){
        return action;
    }

    public LocalDateTime getTimeStamp(){
        return timestamp;
    }

    @Override
    public String toString(){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "[" + timestamp.format(format) + "] " + device + " -> " + action;
    }
}
