import java.math.BigDecimal;

public class TollBooth {

    public BigDecimal calculateToll(Vehicle vehicle) {
        BigDecimal toll = new BigDecimal(0.50);

        toll = calculateAxleUpCharge(vehicle, toll);
        toll = calculateCarpoolDiscount(vehicle, toll);
        return toll;
    }

    private BigDecimal calculateCarpoolDiscount(Vehicle vehicle, BigDecimal toll) {

        if (vehicle.occupants > 2) {

            BigDecimal perPassengerDiscount = new BigDecimal(0.25);
            BigDecimal extraPassengerDiscountMultiplier = new BigDecimal(vehicle.occupants - 2);
            BigDecimal passengerDiscount = perPassengerDiscount.multiply(extraPassengerDiscountMultiplier);
            BigDecimal discountedToll = toll.subtract(passengerDiscount);
            toll = discountedToll;
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
