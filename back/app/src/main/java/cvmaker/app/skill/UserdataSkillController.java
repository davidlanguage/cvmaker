package cvmaker.app.skill;

import cvmaker.app.logger.SaveLogDAO;
import cvmaker.app.logger.LoggerEntity;
import cvmaker.app.logger.LoggerMapper;
import cvmaker.app.userdata.UserDataEntity;
import cvmaker.app.userdata.UserDataRepository;
import cvmaker.app.userdata.UserdataMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/userdataskill/")
@AllArgsConstructor
//TODO: Create Unit Test
public class UserdataSkillController {

    private LoggerMapper loggerMapper;

    private SaveLogDAO saveLogDAO;

    private SaveUserdataSkillDAO saveUserdataSkillDAO;

    final SkillRepository skillRepository;

    final UserDataRepository userDataRepository;

    final UserdataMapper userdataMapper;

    @PostMapping("/create")
    public ResponseEntity<UserdataSkill> createUserDataSkill(@RequestBody final UserdataSkill userdataSkill) {

        //TODO: substitute this repository for a DAO
        final Optional<SkillEntity> skill = skillRepository.findById(userdataSkill.getSkillId());

        //TODO: substitute this repository for a DAO
        final Optional<UserDataEntity> userData = userDataRepository.findById(userdataSkill.getUserdataId());

        if (skill.isEmpty() || userData.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        saveUserdataSkillDAO.addSkill(UserdataSkill
                .builder()
                        .skillId(userdataSkill.getSkillId())
                        .userdataId(userdataSkill.getUserdataId())
                .build());

        saveLogDAO.create(loggerMapper.map(LoggerEntity
                .builder()
                .message("The userdata skill has been added by user id "+userdataSkill.getUserdataId())
                .timestamp(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                .build()));

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
