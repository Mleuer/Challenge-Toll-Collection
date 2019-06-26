import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.Year;

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
}
