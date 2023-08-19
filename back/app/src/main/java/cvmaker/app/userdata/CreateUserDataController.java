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

    @Autowired
    public CreateUserDataController(final CreateUserDataDaoImpl createUserDataDao){
        this.createUserDataDao = createUserDataDao;
    }
    @PostMapping("/create")
    public ResponseEntity<UserData> createUserData(@RequestBody UserData userData){
       createUserDataDao.create(userData);
       return new ResponseEntity<>(HttpStatus.OK);
    }

}
