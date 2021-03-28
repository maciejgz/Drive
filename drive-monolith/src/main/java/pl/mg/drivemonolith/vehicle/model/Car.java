package pl.mg.drivemonolith.vehicle.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@Data
public class Car implements Vehicle {

    @NonNull
    private UUID id;

    @NonNull
    private BigDecimal cost;

    @Override
    public VehicleType getType() {
        return VehicleType.CAR;
    }

    @Override
    public BigDecimal cost() {
        return cost;
    }
}
