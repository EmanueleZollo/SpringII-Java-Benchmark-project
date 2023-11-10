package emanuelespringadvanced.project.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.lang.Nullable;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User{
    @Id
    private String username;
    private String name;
    private String surname;
    private String mail;

    @OneToMany(mappedBy = "user")
    @Nullable
    private List<Device> devices;
}
