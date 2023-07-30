package cvmaker.app.userdata;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Builder
@Getter
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
