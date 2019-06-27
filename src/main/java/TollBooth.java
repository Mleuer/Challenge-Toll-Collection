import java.math.BigDecimal;
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

            BigDecimal perPassengerDiscount = new BigDecimal(0.25);
            BigDecimal extraPassengerDiscountMultiplier = new BigDecimal(vehicle.occupants - 2);
            BigDecimal passengerDiscount = perPassengerDiscount.multiply(extraPassengerDiscountMultiplier);
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
}
