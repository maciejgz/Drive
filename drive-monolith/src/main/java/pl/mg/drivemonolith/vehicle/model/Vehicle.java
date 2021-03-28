package pl.mg.drivemonolith.vehicle.model;

import java.math.BigDecimal;
import java.util.UUID;

public interface Vehicle {

    UUID getId();

    VehicleType getType();

    BigDecimal cost();

}
