import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Vehicle> vehicles = Vehicle.createVehiclesFromText(new File("./DetectedVehicles.txt"));
        TollBooth tollBooth  = new TollBooth();



    }
}
