import java.io.*;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Vehicle {

    public String registration;
    public String make;
    public String model;
    public Year year;
    public int axles;
    public int occupants;

    public Vehicle(String registration, String make, String model, Year year, int axles, int occupants) {
        this.registration = registration;
        this.make = make;
        this.model = model;
        this.year = year;
        this.axles = axles;
        this.occupants = occupants;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vehicle) {
            Vehicle vehicle = (Vehicle)obj;

            if (this.registration.equals(vehicle.registration) &&
                this.make.equals(vehicle.make) &&
                this.model.equals(vehicle.model) &&
                this.year.equals(vehicle.year) &&
                this.axles == vehicle.axles &&
                this.occupants == vehicle.occupants
                )
            {
                return true;
            }

        }
        return false;
    }

    public static String extractVehiclePropertiesFromText(String vehicleDescription, String vehiclePropertyIdentifier) {
        StringBuilder vehicleProperty = new StringBuilder();

        int index = vehicleDescription.indexOf(vehiclePropertyIdentifier);

        int vehiclePropertyStartingIndex = index + vehiclePropertyIdentifier.length();
        char currentCharacter = ' ';

        for (int i = vehiclePropertyStartingIndex;; i++) {
            if (i >= vehicleDescription.length()) {
                break;
            }
            currentCharacter = vehicleDescription.charAt(i);
            if (currentCharacter == ',') {
                break;
            }
            vehicleProperty.append(currentCharacter);
        }

        return vehicleProperty.toString();
    }

    public static Vehicle createVehicleFromText(String vehicleDescription) {

        String registration = extractVehiclePropertiesFromText(vehicleDescription, "Registration: ");
        String make = extractVehiclePropertiesFromText(vehicleDescription, "Make: ");
        String model = extractVehiclePropertiesFromText(vehicleDescription, "Model: ");

        String year = extractVehiclePropertiesFromText(vehicleDescription, "Year: ");
        int resultYear = Integer.parseInt(year);

        String axles = extractVehiclePropertiesFromText(vehicleDescription, "Axles: ");
        int resultAxles = Integer.parseInt(axles);

        String occupants = extractVehiclePropertiesFromText(vehicleDescription, "Occupants: ");
        int resultOccupants = Integer.parseInt(occupants);

        Vehicle createdVehicle = new Vehicle(registration, make, model, Year.of(resultYear), resultAxles, resultOccupants);

        return createdVehicle;
    }

    public static List<Vehicle> createVehiclesFromText(File input) throws IOException {
        BufferedReader inputFileReader = new BufferedReader(new FileReader(input));
        String line = inputFileReader.readLine();

        ArrayList<Vehicle> vehicles = new ArrayList<>();
        while (line != null) {
            vehicles.add(Vehicle.createVehicleFromText(line));
            line = inputFileReader.readLine();
        }
        return vehicles;
    }
}






















