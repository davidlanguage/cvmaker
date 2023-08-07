package cvmaker.app.userdata;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserData {

    private Long id;

    private String firstname;

    private String lastname;

    private String username;

    private String password;

    private String country;

    private Role role;
}
