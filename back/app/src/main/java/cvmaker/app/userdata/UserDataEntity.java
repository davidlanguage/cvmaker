package cvmaker.app.userdata;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDataEntity {

    @Id
    private Long id;

    private String name;

    private String lastname;

    private String email;

    private String password;
}
