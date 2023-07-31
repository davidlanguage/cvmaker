package cvmaker.app.userdata;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDataEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String lastname;

    @NonNull
    @Pattern(regexp=".+@.+\\.[a-z]+", message="Invalid email address!")
    @Size(min = 5, max=100)
    private String email;

    private String password;
}
