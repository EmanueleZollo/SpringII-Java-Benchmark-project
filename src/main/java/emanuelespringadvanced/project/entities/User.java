package emanuelespringadvanced.project.entities;

import jakarta.validation.constraints.Null;
import lombok.*;
import org.springframework.lang.Nullable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private String username;
    private String name;
    private String surname;
    private String mail;
    @Nullable
    private Device device;
}
