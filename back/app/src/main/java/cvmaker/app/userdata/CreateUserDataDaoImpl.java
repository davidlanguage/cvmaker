package cvmaker.app.userdata;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import static cvmaker.app.utils.Validator.validateEmail;
import static cvmaker.app.utils.Validator.isValidPassword;

@Component
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDataDaoImpl implements CreateUserDataDao {

    private UserdataMapper userdataMapper;

    private UserDataRepository userDataRepository;

    @Override
    public boolean create(final UserData userData){

        if (validateEmail(userData.getUsername()) && isValidPassword(userData.getPassword())){
            final UserDataEntity userDataEntity = userdataMapper.mapToEntity(userData);
            userDataRepository.save(userDataEntity);
            return true;
        }
        else {
            return false;
        }
    }


}
