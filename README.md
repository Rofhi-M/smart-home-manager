# 🏠 SmartHomeHub

A robust, console-based Java application designed to manage and monitor smart home devices with high-performance data structures, file persistence, and functional data processing.

## 🚀 Key Features

* **Object-Oriented Programming (OOP):** Built with clean inheritance and polymorphism (`SmartDevice` base class with specialized `SmartLight` and `SmartThermostat` subclasses).
* **Advanced Collections:**
    * `ArrayList` for maintaining ordered device sequences.
    * `HashMap` for instant $O(1)$ device lookups by name.
    * `HashSet` for strict uniqueness enforcement, preventing duplicate device registrations.
* **Functional Programming:** Utilizes Java Streams and Lambdas (`.stream()`, `.filter()`, `.map()`, `.average()`) for declarative data processing and calculations.
* **Data Persistence:** Automatically saves and loads device configurations to and from disk (`smart_home_data.txt`) using `BufferedReader` and `PrintWriter`.

---

## 📂SmartHomeHub/Within the src file
│
├── HomeMain.java                        # Console User Interface & Menu Controller
├── HomeManager.java                     # Business Logic & Collection Management Engine
├── SmartDevice.java                     # Base Model Class with Input Validation
├── SmartLight.java                      # Light Device Subclass (Brightness, Color)
├── SmartThermostat.java                 # Thermostat Device Subclass (Mode, Temperature)
├── DeviceLog.java                       # Immutable Activity Audit Record
├── InvalidDeviceSettingException.java   # Custom Exception for Invalid Device Configurations
└── smart_home_data.txt                  # Local Persistent Data Store

## How to Run
1. Clone the repository:
   ```bash
   git clone [https://github.com/Rofhi-M/smart-home-manager.git](https://github.com/Rofhi-M/smart-home-manager.git)