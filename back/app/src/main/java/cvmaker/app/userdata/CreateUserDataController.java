package cvmaker.app.userdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/")
public class CreateUserDataController {

    private final CreateUserDataDaoImpl createUserDataDao;

    private final UserdataMapper userdataMapper;

    @Autowired
    public CreateUserDataController(final CreateUserDataDaoImpl createUserDataDao, final UserdataMapper userdataMapper){
        this.createUserDataDao = createUserDataDao;
        this.userdataMapper = userdataMapper;
    }
    @PostMapping("/create")
    public ResponseEntity<UserData> createUserData(@RequestBody UserData userData){
        final UserDataEntity userDataEntity = userdataMapper.mapToEntity(userData);
       createUserDataDao.create(userDataEntity);
       return new ResponseEntity<>(HttpStatus.OK);
    }

}
