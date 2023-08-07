package cvmaker.app.userdata;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


@AllArgsConstructor
@NoArgsConstructor
@Component
public class GetUserDataEntityByUsernameDAOImpl implements GetUserDataEntityByUsernameDAO {

    private UserDataRepository userDataRepository;

    @Override
    public UserDataEntity findByUsername(final String email) {

        if (!StringUtils.hasText(email)){
            return UserDataEntity.builder().username("").build();
        }

        return userDataRepository
                .findByUsername(email)
                .orElse(UserDataEntity.builder().build());
    }
}
