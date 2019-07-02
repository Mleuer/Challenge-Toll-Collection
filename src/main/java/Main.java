import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Vehicle> vehicles = Vehicle.createVehiclesFromText(new File("./DetectedVehicles.txt"));
        TollBooth tollBooth  = new TollBooth();

        File outputFile = new File("./VehicleTollsOutput.txt");
        OutputStream outputFileStream = new FileOutputStream(outputFile);

        tollBooth.printAllVehicleTolls(vehicles, outputFileStream);


    }
}
