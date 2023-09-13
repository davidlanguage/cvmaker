package cvmaker.app.userdata;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class CreateUserDataController {

    private final CreateUserDataDaoImpl createUserDataDao;

    private final UserdataMapper userdataMapper;

    @PostMapping("/create")
    public ResponseEntity<UserData> createUserData(@RequestBody final UserData userData){
        final UserDataEntity userDataEntity = userdataMapper.mapToEntity(userData);
       createUserDataDao.create(userDataEntity);
       return new ResponseEntity<>(HttpStatus.OK);
    }

}
