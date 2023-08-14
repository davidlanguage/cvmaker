package cvmaker.app.userdata;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import static cvmaker.app.utils.Validator.*;

@Component
@AllArgsConstructor
public class CreateUserDataDaoImpl implements CreateUserDataDao {

    private UserdataMapper userdataMapper;

    private UserDataRepository userDataRepository;

    @Override
    public boolean create(final UserData userData){
            final UserDataEntity userDataEntity = userdataMapper.mapToEntity(userData);
            userDataRepository.save(userDataEntity);
            return true;

    }


}
