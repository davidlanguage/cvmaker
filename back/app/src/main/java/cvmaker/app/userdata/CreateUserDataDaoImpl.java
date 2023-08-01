package cvmaker.app.userdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
class CreateUserDataDaoImpl implements CreateUserDataDao {

    private final UserdataMapper userdataMapper;
    private final UserDataRepository userDataRepository;

    private static final String WRONG_PATTERN_MESSAGE = "The email provided is wrongly formatted";

    @Autowired
    public CreateUserDataDaoImpl(final UserdataMapper userdataMapper, final UserDataRepository userDataRepository){
        this.userdataMapper = userdataMapper;
        this.userDataRepository = userDataRepository;
    }

    @Override
    public boolean create(final UserData userData){

        if (validateEmail(userData.getEmail())){
            final UserDataEntity userDataEntity = userdataMapper.mapToEntity(userData);
            userDataRepository.save(userDataEntity);
            return true;
        }
        else {
            return false;
        }
    }

    private boolean validateEmail(final String email){

        final Pattern emailPattern = Pattern.compile("^(.+)@(.+)$");

        final Matcher matcher = emailPattern.matcher(email);

        return matcher.find();

    }
}
