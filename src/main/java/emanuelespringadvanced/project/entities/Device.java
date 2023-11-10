package emanuelespringadvanced.project.entities;

import emanuelespringadvanced.project.enums.DeviceStatus;
import emanuelespringadvanced.project.enums.DeviceType;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.lang.Nullable;

@Entity
@Table(name = "devices")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Device {
    @Id
    @GeneratedValue
    private int id;
    // Nullable = true (default)
    @ManyToOne
    @JoinColumn(name= "user_username")
    private User user;
    @Enumerated(EnumType.STRING)
    private DeviceStatus deviceStatus;
    @Enumerated(EnumType.STRING)
    private DeviceType deviceType;

}
