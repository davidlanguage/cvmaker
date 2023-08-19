package cvmaker.app.userdata;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreateUserDataDaoImpl implements CreateUserDataDao {

    private UserdataMapper userdataMapper;

    private UserDataRepository userDataRepository;

    @Override
    public UserData create(final UserData userData){
            final UserDataEntity userDataEntity = userdataMapper.mapToEntity(userData);
            userDataRepository.save(userDataEntity);
            return userData;
    }


}
