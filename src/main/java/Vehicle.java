import java.time.Year;

public class Vehicle {

    public String registration;
    public String make;
    public String model;
    public Year year;
    public int axles;
    public int occupants;

    public static String extractRegistrationFromText(String vehicleDescription) {
        StringBuilder vehicleRegistration = new StringBuilder();
        boolean vehicleRegistrationFound = false;

        for (int i = 0; i < vehicleDescription.length(); i++){
            char character = vehicleDescription.charAt(i);
            if (character == ':') {
                vehicleRegistrationFound = true;
                continue;
            }
            if (character == ',') {
                break;
            }
            if (vehicleRegistrationFound) {
                vehicleRegistration.append(character);
            }
        }
        String cleanedVehicleRegistration = vehicleRegistration.toString();
        cleanedVehicleRegistration = cleanedVehicleRegistration.replaceAll(" ", "");

        return cleanedVehicleRegistration;
    }


    public static Vehicle createVehicleFromText(String vehicleDescription) {
//      Registration: Ecto-1, Make: Cadillac, Model: Fleetwood, Year: 1959, Axles: 2, Occupants: 4

        String registration = extractRegistrationFromText(vehicleDescription);


        return null;
    }
}
