package pl.mg.drive.userweb.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("drive")
public class DriveProperties {
}
