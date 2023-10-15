package cvmaker.app.skill;

import cvmaker.app.logger.CreateLogDAO;
import cvmaker.app.logger.LoggerEntity;
import cvmaker.app.logger.LoggerMapper;
import cvmaker.app.userdata.UserData;
import cvmaker.app.userdata.UserDataRepository;
import cvmaker.app.userdata.UserdataMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
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

    private AddUserdataSkillDAO addUserdataSkillDAO;

    final SkillRepository skillRepository;

    final UserDataRepository userDataRepository;

    final UserdataMapper userdataMapper;

    //TODO: This controller throws Can not get java.lang.Long field cvmaker.app.skill.SkillEntity.id on java.util.ArrayList
    //It is required a change in logic of SkillEntity (see that class)
    //It is also necessary to verify the token first
    @PostMapping("/create{skillId}{userdataId}")
    public ResponseEntity<UserdataSkill> createUserData(@RequestParam final Long skillId, @RequestParam final Long userdataId) throws Exception {

        final Skill skill = skillMapper.map(skillRepository.findById(skillId).orElseThrow(Exception::new));

        final UserData userData = userdataMapper.map(userDataRepository.findById(userdataId).orElseThrow(Exception::new));

        createLogDAO.create(loggerMapper.map(LoggerEntity
                .builder()
                .message("The userdata skill has been added by user "+userData.getUsername())
                .timestamp(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                .build()));

        addUserdataSkillDAO.addSkill(skill, userData);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
