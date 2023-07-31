package cvmaker.app.userdata;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@AllArgsConstructor
class CreateUserDataDaoImpl implements CreateUserDataDao {

    private UserdataMapper userdataMapper;

    private UserDataRepository userDataRepository;

    private static final String WRONG_PATTERN_MESSAGE = "The email provided is wrongly formatted";

    @Override
    public UserData create(final UserData userData) throws EmailHasWrongPatternError {

        if (validateEmail(userData.getEmail())){
            final UserDataEntity userDataEntity = userdataMapper.mapToEntity(userData);
            userDataRepository.save(userDataEntity);
            return userData;
        }
        else {
            throw new EmailHasWrongPatternError(WRONG_PATTERN_MESSAGE);
        }
    }

    private boolean validateEmail(final String email){

        final Pattern emailPattern = Pattern.compile("^(.+)@(.+)$");

        final Matcher matcher = emailPattern.matcher(email);

        return matcher.find();

    }
}
