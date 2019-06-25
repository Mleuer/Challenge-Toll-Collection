import org.junit.Assert;
import org.junit.Test;

public class VehicleTest {

    @Test
    public void VehicleShouldBeCreatedFromText() {
        Vehicle actualVehicle = Vehicle.createVehicleFromText("Registration: Ecto-1, Make: Cadillac, Model: Fleetwood, Year: 1959, Axles: 2, Occupants: 4");

        Vehicle expectedVehicle = new Vehicle("Ecto-1", "Cadillac", "Fleetwood", java.time.Year.of(1992), 2, 4);

        Assert.assertEquals(expectedVehicle, actualVehicle);
    }

    @Test
    public void equalsShouldReturnFalseForUnequalVehicles() {
        Vehicle vehicle1 = new Vehicle("PRIME", "Peterbilt", "379", java.time.Year.of(1992), 3, 0);
        Vehicle vehicle2 = new Vehicle("NO1DAD", "Dodge", "Caravan", java.time.Year.of(2015), 2, 3);

        Assert.assertFalse(vehicle1.equals(vehicle2));
    }

    @Test
    public void equalsShouldReturnTrueForEqualVehicles() {
        Vehicle vehicle1 = new Vehicle("PRIME", "Peterbilt", "379", java.time.Year.of(1992), 3, 0);
        Vehicle vehicle2 = new Vehicle("PRIME", "Peterbilt", "379", java.time.Year.of(1992), 3, 0);

        Assert.assertTrue(vehicle1.equals(vehicle2));
    }

    @Test
    public void extractVehiclePropertiesFromTextShouldExtractRegistrationFromText() {
        String vehicleRegistration = Vehicle.extractVehiclePropertiesFromText("Registration: Ecto-1, Make: Cadillac, Model: Fleetwood, Year: 1959, Axles: 2, Occupants: 4", "Registration: ");

        Assert.assertEquals("Ecto-1", vehicleRegistration);
    }

    @Test
    public void extractVehiclePropertiesFromTextShouldExtractMakeFromText() {
        String vehicleMake = Vehicle.extractVehiclePropertiesFromText("Registration: Ecto-1, Make: Cadillac, Model: Fleetwood, Year: 1959, Axles: 2, Occupants: 4", "Make: ");

        Assert.assertEquals("Cadillac", vehicleMake);
    }

    @Test
    public void extractVehiclePropertiesFromTextShouldExtractModelFromText() {
        String vehicleModel = Vehicle.extractVehiclePropertiesFromText("Registration: Ecto-1, Make: Cadillac, Model: Fleetwood, Year: 1959, Axles: 2, Occupants: 4", "Model: ");

        Assert.assertEquals("Fleetwood", vehicleModel);
    }

    @Test
    public void extractVehiclePropertiesFromTextShouldExtractYearFromText() {
        String vehicleYear = Vehicle.extractVehiclePropertiesFromText("Registration: Ecto-1, Make: Cadillac, Model: Fleetwood, Year: 1959, Axles: 2, Occupants: 4", "Year: ");

        Assert.assertEquals("1959", vehicleYear);
    }

    @Test
    public void extractVehiclePropertiesFromTextShouldExtractAxlesFromText() {
        String vehicleAxles = Vehicle.extractVehiclePropertiesFromText("Registration: Ecto-1, Make: Cadillac, Model: Fleetwood, Year: 1959, Axles: 2, Occupants: 4", "Axles: ");

        Assert.assertEquals("2", vehicleAxles);
    }

    @Test
    public void extractVehiclePropertiesFromTextShouldExtractOccupantsFromText() {
        String vehicleOccupants = Vehicle.extractVehiclePropertiesFromText("Registration: Ecto-1, Make: Cadillac, Model: Fleetwood, Year: 1959, Axles: 2, Occupants: 4", "Occupants: ");

        Assert.assertEquals("4", vehicleOccupants);
    }
}
