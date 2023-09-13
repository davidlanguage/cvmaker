package cvmaker.app.skill;

import cvmaker.app.logger.CreateLogDAO;
import cvmaker.app.logger.LoggerEntity;
import cvmaker.app.logger.LoggerMapper;
import lombok.RequiredArgsConstructor;
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
}
