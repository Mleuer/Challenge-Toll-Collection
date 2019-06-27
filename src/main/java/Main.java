import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<Vehicle> vehicles = Vehicle.createVehiclesFromText(new File("./DetectedVehicles.txt"));

        TollBooth tollBooth  = new TollBooth();



    }
}
