import java.time.Year;

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

//    public static String extractRegistrationFromText(String vehicleDescription) {
//        StringBuilder vehicleRegistration = new StringBuilder();
//        boolean vehicleRegistrationFound = false;
//
//        for (int i = 0; i < vehicleDescription.length(); i++){
//            char character = vehicleDescription.charAt(i);
//            if (character == ':') {
//                vehicleRegistrationFound = true;
//                continue;
//            }
//            if (character == ',') {
//                break;
//            }
//            if (vehicleRegistrationFound) {
//                vehicleRegistration.append(character);
//            }
//        }
//        String cleanedVehicleRegistration = vehicleRegistration.toString();
//        cleanedVehicleRegistration = cleanedVehicleRegistration.replaceAll(" ", "");
//
//        return cleanedVehicleRegistration;
//    }

    public static String extractVehiclePropertiesFromText(String vehicleDescription, String propertyIdentifier) {
        StringBuilder vehicleProperty = new StringBuilder();

        int index = vehicleDescription.indexOf(propertyIdentifier);

        int vehiclePropertyStartingIndex = index + propertyIdentifier.length();
        char currentCharacter = ' ';

        for (int i = vehiclePropertyStartingIndex;; i++) {
            currentCharacter = vehicleDescription.charAt(i);
            if (currentCharacter == ',') {
                break;
            }
            vehicleProperty.append(currentCharacter);
        }

        return vehicleProperty.toString();
    }

    public static Vehicle createVehicleFromText(String vehicleDescription) {
//      Registration: Ecto-1, Make: Cadillac, Model: Fleetwood, Year: 1959, Axles: 2, Occupants: 4

        String registration = extractVehiclePropertiesFromText(vehicleDescription, "Registration: ");
        String make = extractVehiclePropertiesFromText(vehicleDescription, "Make: ");
        String model = extractVehiclePropertiesFromText(vehicleDescription, "Model: ");
        String year = extractVehiclePropertiesFromText(vehicleDescription, "Year: ");
        String axles = extractVehiclePropertiesFromText(vehicleDescription, "Axles: ");
        String occupants = extractVehiclePropertiesFromText(vehicleDescription, "Occupants: ");

        return null;
    }


}






















