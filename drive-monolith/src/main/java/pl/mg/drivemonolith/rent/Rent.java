package pl.mg.drivemonolith.rent;

import lombok.Data;

import java.util.UUID;

/**
 * Rent represents a process of vehicle rent. It can be unsuccessful. Only one travel can be assigned to a rent.
 */
@Data
public class Rent {

    private UUID rentId;

}
