package cvmaker.app.userdata;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class CreateUserDataDaoImpl implements CreateUserDataDao {

    private final UserdataMapper userdataMapper;

    private final UserDataRepository userDataRepository;

    @Override
    public UserData create(final UserDataEntity userDataEntity){
            userDataRepository.save(userDataEntity);
            final UserData userData = userdataMapper.map(userDataEntity);
            return userData;
    }


}
