package cvmaker.app.skill;

import cvmaker.app.logger.Logger;
import cvmaker.app.logger.LoggerService;
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

    //TODO: Include all XSkillDAO in a SkillService
    private final GetAllSkillsDAO getAllSkillsDAO;

    private final SaveSkillDAO saveSkillDAO;

    private final LoggerService loggerService;

    @GetMapping("all")
    public ResponseEntity<List<Skill>> getAllSkills(){

        loggerService.create(Logger
                .builder()
                .message("A user has checked all skills")
                .timestamp(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                .build());

        return ResponseEntity.of(Optional.ofNullable(getAllSkillsDAO.getAllSkills()));
    }

    @PostMapping("/create")
    public ResponseEntity<Skill> createUserData(@RequestBody final Skill skill){

        final List<Skill> allSkills = getAllSkillsDAO.getAllSkills();

        //TODO this logic should be in a SkillService
        final Boolean skillAlreadyExists = allSkills.stream().anyMatch(s -> s.getSkillName().equalsIgnoreCase(skill.getSkillName()));

        if(skillAlreadyExists){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        saveSkillDAO.saveSkill(skill);

        loggerService.create(Logger
                .builder()
                .message("The skill "+skill.getSkillName()+ " has been added to the database")
                .timestamp(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
                .build());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
