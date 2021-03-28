package pl.mg.drivemonolith.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.UUID;

@Data
@AllArgsConstructor
public class User {

    @NonNull
    private UUID id;

    @NonNull
    private String username;

}
