package cvmaker.app.skill;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllSkillsDAOImpl implements GetAllSkillsDAO{

    private final SkillRepository skillRepository;

    private final SkillMapper skillMapper;

    @Override
    public List<Skill> getAllSkills() {
        return skillRepository.findAll().stream().map(skillMapper::map).toList();
    }
}
