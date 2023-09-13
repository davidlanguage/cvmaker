package cvmaker.app.userdata;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


@AllArgsConstructor
@NoArgsConstructor
@Component
class GetUserDataEntityByUsernameDAOImpl implements GetUserDataEntityByUsernameDAO {

    private UserDataRepository userDataRepository;

    @Override
    public UserDataEntity findByUsername(final String email) {

        if (!StringUtils.hasText(email)){
            return UserDataEntity.builder().username(Strings.EMPTY).build();
        }

        return userDataRepository
                .findByUsername(email)
                .orElse(UserDataEntity.builder().build());
    }
}
