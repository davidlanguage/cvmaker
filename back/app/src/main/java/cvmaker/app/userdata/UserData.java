package cvmaker.app.userdata;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserData {

    private Long id;

    private String name;

    private String lastname;

    @NonNull
    @Pattern(regexp=".+@.+\\.[a-z]+", message="Invalid email address!")
    @Size(min = 5, max=100)
    private String email;

    private String password;
}
