package cvmaker.app.userdata;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserData {

    private Long id;

    private String name;

    private String lastname;

    private String email;

    private String password;
}
