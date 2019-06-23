import org.junit.Assert;
import org.junit.Test;

public class VehicleTest {

    @Test

    public void VehicleShouldBeCreatedFromText() {
        Vehicle newVehicle = Vehicle.createVehicleFromText("Registration: Ecto-1, Make: Cadillac, Model: Fleetwood, Year: 1959, Axles: 2, Occupants: 4");

        Assert.assertEquals("Ecto-1", newVehicle.registration);
        Assert.assertEquals("Cadillac", newVehicle.make);
        Assert.assertEquals("Fleetwood", newVehicle.model);
        Assert.assertEquals("1959", newVehicle.year);
        Assert.assertEquals("2", newVehicle.axles);
        Assert.assertEquals("4", newVehicle.occupants);
    }
}
