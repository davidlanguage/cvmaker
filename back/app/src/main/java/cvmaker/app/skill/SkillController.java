package cvmaker.app.skill;

import cvmaker.app.logger.CreateLogDAO;
import cvmaker.app.logger.LoggerEntity;
import cvmaker.app.logger.LoggerMapper;
import cvmaker.app.userdata.UserData;
import cvmaker.app.userdata.UserDataEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/skill/")
@RequiredArgsConstructor
public class SkillController {

    private final GetAllSkillsDAO getAllSkillsDAO;

    private final SaveSkillDAO saveSkillDAO;

    private final CreateLogDAO createLogDAO;

    private final LoggerMapper loggerMapper;

    @GetMapping("all")
    public ResponseEntity<List<Skill>> getAllSkills(){
        createLogDAO.create(loggerMapper.map(LoggerEntity
                .builder()
                .message("A user has checked all skills")
                .timestamp(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                .build()));
        return ResponseEntity.of(Optional.ofNullable(getAllSkillsDAO.getAllSkills()));
    }

    @PostMapping("/create")
    public ResponseEntity<Skill> createUserData(@RequestBody final Skill skill){

        saveSkillDAO.saveSkill(skill);

        createLogDAO.create(loggerMapper.map(LoggerEntity
                .builder()
                .message("The skill "+skill.getSkillName()+ " has been added to the database")
                .timestamp(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                .build()));

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
