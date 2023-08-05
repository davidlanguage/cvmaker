package cvmaker.app.userdata;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "userdata")
public class UserDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String lastname;

    @NonNull
    @Pattern(regexp=".+@.+\\.[a-z]+", message="Invalid email address!")
    @Size(min = 5, max=100)
    private String email;

    private String password;
}
