package cvmaker.app.skill;

import cvmaker.app.logger.CreateLogDAO;
import cvmaker.app.logger.LoggerEntity;
import cvmaker.app.logger.LoggerMapper;
import cvmaker.app.userdata.UserData;
import cvmaker.app.userdata.UserDataRepository;
import cvmaker.app.userdata.UserdataMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@CrossOrigin
@RestController
@RequestMapping("/userdataskill/")
@AllArgsConstructor
public class UserdataSkillController {

    private SkillMapper skillMapper;

    private LoggerMapper loggerMapper;

    private CreateLogDAO createLogDAO;

    private SaveUserdataSkillDAO saveUserdataSkillDAO;

    final SkillRepository skillRepository;

    final UserDataRepository userDataRepository;

    final UserdataMapper userdataMapper;
    
    @PostMapping("/create")
    public ResponseEntity<UserdataSkill> createUserData(@RequestBody final UserdataSkill userdataSkill) {


        saveUserdataSkillDAO.addSkill(UserdataSkill
                .builder()
                        .skillId(userdataSkill.getSkillId())
                        .userdataId(userdataSkill.getUserdataId())
                .build());

        createLogDAO.create(loggerMapper.map(LoggerEntity
                .builder()
                .message("The userdata skill has been added by user id "+userdataSkill.getUserdataId())
                .timestamp(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                .build()));

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
