package pl.mg.drivemonolith.vehicle.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Bicycle implements Vehicle {

    @NonNull
    private UUID id;

    /**
     * Cost of rental per minute.
     */
    @NonNull
    private BigDecimal cost;

    @Override
    public VehicleType getType() {
        return VehicleType.BICYCLE;
    }

    @Override
    public BigDecimal cost() {
        return cost;
    }
}
