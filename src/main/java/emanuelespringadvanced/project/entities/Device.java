package emanuelespringadvanced.project.entities;

import emanuelespringadvanced.project.enums.DeviceStatus;
import emanuelespringadvanced.project.enums.DeviceType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.springframework.lang.Nullable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Device {
    @Nullable
    private User user;
    @Enumerated(EnumType.STRING)
    private DeviceStatus deviceStatus;
    @Enumerated(EnumType.STRING)
    private DeviceType deviceType;

}
