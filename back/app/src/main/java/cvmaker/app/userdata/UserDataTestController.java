package cvmaker.app.userdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/")
public class UserDataTestController {

    private CreateUserDataDaoImpl createUserDataDao;
    private UserDataRepository userDataRepository;

    @Autowired
    public UserDataTestController(CreateUserDataDaoImpl createUserDataDao, UserDataRepository userDataRepository){
        this.createUserDataDao = createUserDataDao;
        this.userDataRepository = userDataRepository;
    }
    @PostMapping("/create")
    public ResponseEntity<UserData> createUserData(@RequestBody UserData userData) throws EmailHasWrongPatternError {
       final UserData returnedUserData = createUserDataDao.create(userData);
       return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/testall")
    public List<UserDataEntity> testAll() {
        return userDataRepository.findAll();
    }
    @GetMapping("/test")
    public String test(){
        return "It works!";
    }
}
