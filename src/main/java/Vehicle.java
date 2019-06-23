import java.time.Year;

public class Vehicle {

    public String registration;
    public String make;
    public String model;
    public Year year;
    public int axles;
    public int occupants;

    public static Vehicle createVehicleFromText(String s) {
        return new Vehicle();
    }
}
