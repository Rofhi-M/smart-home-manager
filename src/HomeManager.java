import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class HomeManager {
    private ArrayList<SmartDevice> sds;
    private Map<String, SmartDevice> sdsMap;
    private Set<String> registeredDevices;

    public HomeManager() {
        sds = new ArrayList<>();
        sdsMap = new HashMap<>();
        registeredDevices = new HashSet<>();
    }

    public boolean addItem(SmartDevice sd) {
        String key = sd.getDeviceName();
        boolean isUnique = registeredDevices.add(key);

        if (!isUnique) {
            System.out.println("A device with the same name already exists!");
            return false;
        }

        this.sds.add(sd);
        this.sdsMap.put(key, sd);
        return true;
    }

    public SmartDevice getItem(String deviceName) {
        return this.sdsMap.get(deviceName.toLowerCase());
    }

    public double getAverageTemp() {
        return sds.stream()
                .filter(sd -> sd instanceof SmartThermostat)
                .map(sd -> (SmartThermostat) sd)
                .mapToDouble(SmartThermostat::getTemp)
                .average()
                .orElse(0.0);
    }

    public void filterLocations(String rooms) {
        System.out.println("\n=== Filtered Results for Rooms: " + rooms + " ===");
        boolean found = false;
        for (SmartDevice sd : sds) {
            if(sd.getRoom().equalsIgnoreCase(rooms)) {
                System.out.println(sd);
                found = true;
            }
        }

        if(!found) {
            System.out.println("Rooms: " + rooms + " not found");
        }

    }

    public void saveFile(String fileName) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
            for (SmartDevice sd : sds) {
                if (sd instanceof SmartThermostat) {
                    SmartThermostat t = (SmartThermostat) sd;
                    pw.println("Thermostat," + t.getDeviceName() + "," + t.getRoom() + "," + t.getIsOn() + "," + t.getMode() + "," + t.getTemp());
                } else if (sd instanceof SmartLight) {
                    SmartLight l = (SmartLight) sd;
                    pw.println("Light," + l.getDeviceName() + "," + l.getRoom() + "," + l.getIsOn() + "," + l.getBrightness() + "," + l.getColor());
                }
            }
            System.out.println("Data successfully saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing file");
        }
    }

    public void loadFile(String fileName) {
        File file = new File(fileName);
        if(!file.exists()) {
            return;
        }

        try(BufferedReader bf = new BufferedReader(new FileReader(fileName))) {
            String line;

            while((line = bf.readLine()) != null) {
                String[] parts = line.split(",");

                if(parts.length > 0) {
                    String type  = parts[0];

                    if(type.equalsIgnoreCase("Thermostat") && parts.length == 6) {
                        String deviceName = parts[1];
                        String room = parts[2];
                        boolean isOn = Boolean.parseBoolean(parts[3]);
                        String mode = parts[4];
                        double temp = Double.parseDouble(parts[5]);

                        sds.add(new SmartThermostat(deviceName, room, isOn, mode, temp));
                    }
                    else if(type.equalsIgnoreCase("Light") && parts.length == 6) {
                        String deviceName = parts[1];
                        String room = parts[2];
                        boolean isOn = Boolean.parseBoolean(parts[3]);
                        int brightness =  Integer.parseInt(parts[4]);
                        String color = parts[5];

                        sds.add(new SmartLight(deviceName, room, isOn, brightness, color));
                    }

                }

            }
            System.out.println("Data successfully loaded from " + fileName);
        }catch (IOException | NumberFormatException e) {
            System.out.println("An error occurred while loading: " + e.getMessage());
        }
    }

}
