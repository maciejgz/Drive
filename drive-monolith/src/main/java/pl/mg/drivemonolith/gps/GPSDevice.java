package pl.mg.drivemonolith.gps;

import lombok.Data;
import lombok.NonNull;

import java.util.UUID;

/**
 * GPS device attached to the vehicle.
 */
@Data
public class GPSDevice {

    @NonNull
    private final UUID deviceId;

}
