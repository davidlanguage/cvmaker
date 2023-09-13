package cvmaker.app.skill;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/testing/")
@RequiredArgsConstructor
public class SkillController {

    private final GetAllSkillsDAO getAllSkillsDAO;

    @GetMapping("asd")
    public List<Skill> getAllSkills(){
        return getAllSkillsDAO.getAllSkills();
    }
}
