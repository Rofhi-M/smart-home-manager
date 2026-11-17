import java.util.Scanner;

public class HomeMain {
    public  static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        HomeManager home = new HomeManager();

        home.loadFile("smart_home_data.txt");

        int choice = 0;

        do{
            System.out.println("\n==================================");
            System.out.println("      SMART HOME HUB DASHBOARD    ");
            System.out.println("==================================");
            System.out.println("1. Add Smart Light");
            System.out.println("2. Add Smart Thermostat");
            System.out.println("3. Check Average Thermostat Temperature");
            System.out.println("4. Filter Devices by Room");
            System.out.println("5. Save Data to File");
            System.out.println("6. Exit and Save");
            System.out.print("Choose an option (1-6): ");

            try {
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter device name (e.g., Living Room Light): ");
                        String lName = scanner.nextLine();
                        System.out.print("Enter room: ");
                        String lRoom = scanner.nextLine();
                        System.out.print("Do you want to turn appliance? (Yes/NO):: ");
                        String lIsOn = scanner.nextLine();

                        int brightness = 0;
                        String color = "";

                        if(lIsOn.equalsIgnoreCase("yes")){
                            System.out.print("Enter brightness (0-100): ");
                            brightness = Integer.parseInt(scanner.nextLine());
                            System.out.print("Enter color (e.g., Warm White, Blue): ");
                            color = scanner.nextLine();
                        }


                        home.addItem(new SmartLight(lName, lRoom, lIsOn, brightness, color));
                        System.out.println("✅ Smart Light added successfully!");
                        break;

                    case 2:
                        System.out.print("Enter device name (e.g., Hallway Thermostat): ");
                        String tName = scanner.nextLine();
                        System.out.print("Enter room: ");
                        String tRoom = scanner.nextLine();
                        System.out.print("Do you want to turn appliance? (Yes/NO): ");
                        String tIsOn = scanner.nextLine();

                        double temp = 0.0;
                        String mode = "";

                        if(tIsOn.equalsIgnoreCase("yes")){
                            System.out.print("Enter mode (Heating/Cooling): ");
                            mode = scanner.nextLine();
                            System.out.print("Enter target temperature (°C): ");
                            temp = Double.parseDouble(scanner.nextLine());
                        }

                        home.addItem(new SmartThermostat(tName, tRoom, tIsOn, mode, temp));
                        System.out.println("✅ Smart Thermostat added successfully!");
                        break;

                    case 3:
                        double avgTem = home.getAverageTemp();
                        System.out.println("\n🌡️ Average Thermostat Temperature: " + String.format("%.2f", avgTem) + " °C");
                        break;

                    case 4:
                        System.out.print("Enter room name to filter: ");
                        String filterRoom = scanner.nextLine();
                        home.filterLocations(filterRoom);
                        break;

                    case 5:
                        home.saveFile("smart_home_data.txt");
                        break;

                    case 6:
                            System.out.print("Enter device name you looking for(e.g., Living Room Light): ");
                            String findDevice = scanner.nextLine();
                            SmartDevice found = home.getItem(findDevice);

                            if(found != null) {
                                System.out.println(found);
                            }
                            else {
                                System.out.println("Device not found!");
                            }

                            break;

                    case 7:
                        home.saveFile("smart_home_data.txt");
                        System.out.println("Exiting SmartHomeHub. Have a great day!");
                        break;

                    default:
                        System.out.println("❌ Invalid choice. Please enter a number between 1 and 6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input format. Please enter a valid number where required.");
            }

        }while(choice != 7);

        scanner.close();
    }
}

