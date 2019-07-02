import jdk.internal.org.jline.terminal.impl.AbstractWindowsConsoleWriter;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class TollBooth {

    public BigDecimal calculateTotalToll(List<Vehicle> vehicles) {
        BigDecimal totalTolls = new BigDecimal(0);
        for (Vehicle vehicle : vehicles) {
            totalTolls = totalTolls.add(calculateToll(vehicle));
        }

        return totalTolls;
    }

    public BigDecimal calculateToll(Vehicle vehicle) {
        BigDecimal toll = new BigDecimal(0.50);

        toll = calculateAxleUpCharge(vehicle, toll);
        toll = calculateCarpoolDiscount(vehicle, toll);
        toll = calculateEmissionsSurcharge(vehicle, toll);
        return toll;
    }

    private BigDecimal calculateEmissionsSurcharge(Vehicle vehicle, BigDecimal toll) {

        if (vehicle.year.isBefore(Year.of(1995))) {
            BigDecimal upCharge = new BigDecimal(0.25);
            toll = toll.add(upCharge);
        }
        return toll;
    }

    private BigDecimal calculateCarpoolDiscount(Vehicle vehicle, BigDecimal toll) {
        if (vehicle.occupants > 2) {
            BigDecimal passengerDiscount = new BigDecimal(0.25);
            toll = toll.subtract(passengerDiscount);
        }
        return toll;
    }

    private BigDecimal calculateAxleUpCharge(Vehicle vehicle, BigDecimal toll) {
        if (vehicle.axles > 2) {
            BigDecimal extraAxles = new BigDecimal(vehicle.axles - 2.0);
            BigDecimal perAxleSurcharge = new BigDecimal(0.50);
            BigDecimal upCharge = perAxleSurcharge.multiply(extraAxles);

            toll = toll.add(upCharge);
        }
        return toll;
    }

    public void printVehicleToll(Vehicle vehicle, OutputStream output) {
        BigDecimal toll = calculateToll(vehicle);
        toll = toll.setScale(2, RoundingMode.HALF_UP);

        PrintStream outputWriter = new PrintStream(output);
        outputWriter.println("Registration: " + vehicle.registration + ", Toll: $" + toll);
    }

    public void printAllVehicleTolls(List<Vehicle> vehicles, OutputStream outputStream) {
        BigDecimal totalToll = calculateTotalToll(vehicles);
        totalToll = totalToll.setScale(2, RoundingMode.HALF_UP);

        for (Vehicle vehicle: vehicles) {
            printVehicleToll(vehicle, outputStream);
        }
        PrintStream outputWriter = new PrintStream(outputStream);
        outputWriter.println("Total: $" + totalToll);
    }
}





































