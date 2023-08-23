package cvmaker.app.userdata;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreateUserDataDaoImpl implements CreateUserDataDao {

    private UserdataMapper userdataMapper;

    private UserDataRepository userDataRepository;

    @Override
    public UserData create(final UserDataEntity userDataEntity){
            userDataRepository.save(userDataEntity);
            final UserData userData = userdataMapper.map(userDataEntity);
            return userData;
    }


}
