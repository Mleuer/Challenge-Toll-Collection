import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;

public class TollBoothTest {

    @Test
    public void calculateTollShouldCalculateFiftyCentTollByDefault() {
           Vehicle vehicle = new Vehicle("Ecto-1", "Cadillac", "Fleetwood", Year.of(2000), 2, 2);
           TollBooth tollBooth = new TollBooth();

           BigDecimal actualToll = tollBooth.calculateToll(vehicle);
           BigDecimal expectedToll = new BigDecimal(0.50);

           Assert.assertEquals(expectedToll, actualToll);
    }

    @Test
    public void calculateTollShouldChargeAdditionalFiftyCentsForEveryAxleMoreThanTwo() {
           Vehicle vehicle = new Vehicle("Ecto-1", "Cadillac", "Fleetwood", Year.of(2000), 5, 2);
           TollBooth tollBooth = new TollBooth();

           BigDecimal actualToll = tollBooth.calculateToll(vehicle);
           BigDecimal expectedToll = new BigDecimal(2.0);

           Assert.assertEquals(0, actualToll.compareTo(expectedToll));
    }

    @Test
    public void calculateTollShouldDiscountTwentyFiveCentsForPassengersMoreThanTwo() {
            Vehicle vehicle = new Vehicle("Ecto-1", "Cadillac", "Fleetwood", Year.of(2000), 2, 3);
            TollBooth tollBooth = new TollBooth();

            BigDecimal actualToll = tollBooth.calculateToll(vehicle);
            BigDecimal expectedToll = new BigDecimal(0.25);

            Assert.assertEquals(0, actualToll.compareTo(expectedToll));
    }

    @Test
    public void calculateTollShouldAddTwentyFiveCentsForVehicleManufacturedBefore1995() {
            Vehicle vehicle = new Vehicle("Ecto-1", "Cadillac", "Fleetwood", Year.of(1990), 2, 2);
            TollBooth tollBooth = new TollBooth();

            BigDecimal actualToll = tollBooth.calculateToll(vehicle);
            BigDecimal expectedToll = new BigDecimal(0.75);

            Assert.assertEquals(0, actualToll.compareTo(expectedToll));
    }

    @Test
    public void calculateTotalTollShouldCalculateSumOfTollsForAllVehicles() {
            Vehicle vehicle1 = new Vehicle("Ecto-1", "Cadillac", "Fleetwood", Year.of(1990), 2, 2);  // .75
            Vehicle vehicle2 = new Vehicle("PRIME", "Peterbilt", "379", Year.of(1992), 3, 0);  // 1.25
            Vehicle vehicle3 = new Vehicle("NO1DAD", "Dodge", "Caravan", Year.of( 2015), 2, 3);  // .25
            Vehicle vehicle4 = new Vehicle("L43S322", "Mack", "Titan", Year.of( 2008), 6, 1);  // 2.50
            Vehicle vehicle5 = new Vehicle("OUTATIME", "DeLorean", "DeLorean", Year.of( 1982), 2, 1);  // .75
            List<Vehicle> vehicles = Arrays.asList(vehicle1, vehicle2, vehicle3, vehicle4, vehicle5);

            TollBooth tollBooth = new TollBooth();

            BigDecimal actualToll = tollBooth.calculateTotalToll(vehicles);
            BigDecimal expectedToll = new BigDecimal(5.50);

            Assert.assertEquals(0, actualToll.compareTo(expectedToll));
    }

    @Test
    public void printVehicleTollShouldPrintFormattedVehicleRegistrationAndToll() {
            Vehicle vehicle = new Vehicle("Ecto-1", "Cadillac", "Fleetwood", Year.of(1959), 2, 3);
            TollBooth tollBooth = new TollBooth();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            tollBooth.printVehicleToll(vehicle, outputStream);

            Assert.assertEquals("Registration: Ecto-1, Toll: $0.50\n", outputStream.toString());
    }
}
































